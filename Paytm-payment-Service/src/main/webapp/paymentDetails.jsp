<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<%--	Thymeleaf is a Java-based library used to create a web application. It provides a good support for serving a XHTML/HTML5 in web applications --%>

<head>
    <meta charset="UTF-8"/>
    <title>Title</title>
    <link rel="stylesheet" th:href="@{/style.css}"/>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"/>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <style type="text/css">
    div {
  border-radius: 5px;
  background-color: #f2f2f2;
 }
 button[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
 </style>
</head>
<body>

<form action="/pgredirect" method = "post">

    <div class="container register">
        <div class="row">
            <div class="col-md-3 register-left">
            </div>
            <div class="col-md-9 register-right">
                <div class="tab-content" id="myTabContent">
                    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                        <h3 class="register-heading">Welcome to Paytm Payment</h3>
                        <div class="row register-form">
                            <div class="col-md-10">
                            </div>
                                
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Enter the Customer ID" value=""
                                           name="CUST_ID"/>
                                           </div>
                                           <br>
                                           
                                      <div class="form-group">      
                                    <input id="ORDER_ID" class="form-control"  placeholder="Enter the ORDER ID"
                                           name="ORDER_ID"  >
                                           </div>
                                                    
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Enter Your Name" value=""
                                           name="NAME"/>
                                            <br>
                          
                                           <div class="form-group">
                                    <input type="Number" class="form-control" placeholder="Enter Your Number" value=""
                                           name="Phone no"/>
                                            <br>          
                                            
                                            <div class="form-group">
                                    <input type="Number" class="form-control" placeholder="Enter your Bank Account Number" value=""
                                           name="Account no"/>
                                            <br>
                                             <div class="form-group">
                                    <input type="Number" class="form-control" placeholder="Enter your Bank IFSC code" value=""
                                           name="IFSC code"/>
                                            <br>
                               </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Total Amount" value=""
                                           name="TXN_AMOUNT"/>
                                            <br>
                                </div>
                                <button type="submit" class="btnRegister" style="align : center">Pay with Paytm</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
    
</form>

</body>
</html>