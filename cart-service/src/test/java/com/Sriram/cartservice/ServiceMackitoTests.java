package com.Sriram.cartservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PathVariable;

import com.Sriram.cartservice.controller.CartController;
import com.Sriram.cartservice.model.Cart;
import com.Sriram.cartservice.repository.CartRepository;
import com.google.common.base.Optional;

@SpringBootTest(classes= {ServiceMackitoTests.class})
public class ServiceMackitoTests {
	
	@Mock
	CartRepository cartrepo;
	
	
	@InjectMocks
	CartController cartController;
	
	public List<Cart> mycart;
	
	
	@Test
	public void test_getAllCart()
	{
		List<Cart> mycart=new ArrayList<Cart>();
		mycart.add(new Cart(123,999,1,"Sriram.img","pname",444,100.999));
			
		when(cartrepo.findAll()).thenReturn(mycart);	
			assertEquals(1,cartController.getAllCarts().size());
	}
	
	
	
	

}
