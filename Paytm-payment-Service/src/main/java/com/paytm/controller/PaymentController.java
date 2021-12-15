package com.paytm.controller;

import java.util.Map;
import java.util.TreeMap;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.paytm.config.PaytmDetails;
import com.paytm.pg.merchant.PaytmChecksum;

@Controller
public class PaymentController {
	
	//step5: here we need to inject paytm details object , so that we can get all the merchant id, key,etc
	@Autowired
	private PaytmDetails paytmDetails;
	
	@Autowired
	private Environment env;	//this will inject all the paytm details from app.properties file
	
	
	//step4: i am wring a method which will display an jsp page 
	@RequestMapping("/payments")
	public String getPaymentDetails() {
		return "paymentDetails.jsp";
	}
	
	
	//step6: Once someone clicks on the url in form of jsp file the url will come to this controller.
	@PostMapping("/pgredirect")
	public ModelAndView getRedirect(@RequestParam(name = "CUST_ID") String customerId,
            @RequestParam(name = "TXN_AMOUNT") String transactionAmount,
            @RequestParam(name = "ORDER_ID") String orderId) throws Exception {
		
		//step7: all the above request i am redirecting is to paytm url i.e paytmDetails.getPaytmUrl(),for that
		//i created a model and view object which is redirecting to	paytmDetails.getPaytmUrl()-this url is something which i mentioned im app.yml file
		ModelAndView modelAndView = new ModelAndView("redirect:" + paytmDetails.getPaytmUrl());
		//step8: i created a map here named as parameter
		TreeMap<String, String> parameters = new TreeMap<>();
		
		//and from paytm details i extracting all values and storing it in parameters
		paytmDetails.getDetails().forEach((k, v) -> parameters.put(k, v));
		parameters.put("MOBILE_NO", env.getProperty("paytm.mobile"));
		parameters.put("EMAIL", env.getProperty("paytm.email"));
		parameters.put("ORDER_ID", orderId);	//this order id and transaction amount we will get it from request that we will input
		parameters.put("TXN_AMOUNT", transactionAmount);
		parameters.put("CUST_ID", customerId);
		String checkSum = getCheckSum(parameters);	//getchecksum is a paytm dependency to calculate checksum
		parameters.put("CHECKSUMHASH", checkSum);	//then tht checksum on above, i am adding it im parametes now
		modelAndView.addAllObjects(parameters);		//and then giving it to model and view object
		return modelAndView;
	}
	
	//step11: once our payment transaction is made it will redirect to this response page.
	@PostMapping(value = "/pgresponse")
    public String getResponseRedirect(HttpServletRequest request, Model model) {

        Map<String, String[]> mapData = request.getParameterMap();
        TreeMap<String, String> parameters = new TreeMap<String, String>();
        mapData.forEach((key, val) -> parameters.put(key, val[0]));
        String paytmChecksum = "";
        if (mapData.containsKey("CHECKSUMHASH")) {		// i am checking if map contains checksum or not
            paytmChecksum = mapData.get("CHECKSUMHASH")[0];
        }
        String result;

        boolean isValideChecksum = false;
        System.out.println("RESULT : "+parameters.toString());
        try {
            isValideChecksum = validateCheckSum(parameters, paytmChecksum);
            if (isValideChecksum && parameters.containsKey("RESPCODE")) {	//then i am doing checksum validation over here
                if (parameters.get("RESPCODE").equals("01")) {				//i.e if i am getting response code as 1 then payment is successful,if not payment will fail
                    result = "Payment Successful";
                } else {
                    result = "Payment Failed";
                }
            } else {
                result = "Checksum mismatched";
            }
        } catch (Exception e) {
            result = e.toString();
        }
        model.addAttribute("result",result);	// after payment whatever the response i will be getting i will capture it in result variable
        parameters.remove("CHECKSUMHASH");
        model.addAttribute("parameters",parameters);
        return "report.jsp";
    }

	//step10: this method will validate our check sum
	private boolean validateCheckSum(TreeMap<String, String> parameters, String paytmChecksum) throws Exception {
		
		return PaytmChecksum.verifySignature(parameters, paytmDetails.getMerchantKey(), paytmChecksum);
	}
	
	//step 9: now i created a method to generate checksum
	private String getCheckSum(TreeMap<String, String> parameters) throws Exception{
		return PaytmChecksum.generateSignature(parameters,paytmDetails.getMerchantKey());
	}
}
