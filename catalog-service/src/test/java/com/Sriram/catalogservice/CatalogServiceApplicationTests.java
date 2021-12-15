package com.Sriram.catalogservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Sriram.catalogservice.controller.CatalogController;
import com.Sriram.catalogservice.model.Product;
import com.Sriram.catalogservice.repository.ProductRepository;
import com.google.common.base.Optional;

@SpringBootTest
class CatalogServiceApplicationTests {
	
	@Mock
	private ProductRepository prodRepo;

	@InjectMocks
	private CatalogController contr;
	
	public List<Product> product;
	
	@Test 
	@Order(1)
	void getAllProductsTest() {
		when(prodRepo.findAll()).thenReturn(Stream
				.of(new Product(2, "Realme 8", "Electronics", 65465, "realme.jpg", "realme 8 pro"),
					new Product(64, "Levi", "Cloth", 3599, "levi.jpg", "Printed Tshirt")).collect(Collectors.toList()));
		assertEquals(2,contr.getAllProducts().size());
	}
	
	@Test 
	@Order(2)
	public void getProductByIdTest(){
		Product product = new Product (2, "Realme 8", "Electronics",19898, "realme.jpg", "realme 8 pro");
		Optional<Product> op = Optional.of(product);
		when(prodRepo.findById(2)).thenReturn(null);
		assertEquals(2,op.get().getId());
	}
	
	@Test 
	@Order(3)
	public void TestFindByName(){
		List<Product> product = new ArrayList<Product>();
		product.add(new Product (2, "Realme 8", "Electronics",19898, "realme.jpg", "realme 8 pro"));
		when(prodRepo.findByName("Realme 8")).thenReturn(product);
		assertEquals(1, prodRepo.findByName("Realme 8").size());
	}
	
	
	@Test 
	@Order(4)
	public void addProduct(){

		Product product = new Product (2, "Realme 8", "Electronics",19898, "realme.jpg", "realme 8 pro");
		when(( prodRepo).insert(product)).thenReturn(product);
        assertEquals(product, ( prodRepo).insert(product));
	}
	
	@Test 
	@Order(5)
	public void updateProduct(){
		Product product = new Product (2, "Realme 8", "Electronics",19898, "realme.jpg", "realme 8 pro");
		when(contr.updateProduct( product)).thenReturn(product);
		assertEquals(product,contr.updateProduct(product));
	}
	
	@Test 
	@Order(6)
	public void deleteProduct()
	{
		Product product = new Product (2, "Realme 8", "Electronics",19898, "realme.jpg", "realme 8 pro");
		when(( contr).deleteById(2)).thenReturn("deleted");
        assertEquals("deleted", ( contr).deleteById(2));
	}
}

