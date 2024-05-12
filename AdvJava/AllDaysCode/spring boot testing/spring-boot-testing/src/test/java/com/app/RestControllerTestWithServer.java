package com.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.app.pojos.Product;

//Integration Test : complete end to end testing
//creates a web app context (SC) using any available random free port.
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class RestControllerTestWithServer {
	//randomly available free port is injected in local server port
	@LocalServerPort
	private int serverPort;
	// Abstraction of REST client to be used in test scenario
	@Autowired
	private TestRestTemplate template;

	@Test
	public void testTestConroller() throws Exception {

		String response = template.getForObject
				("http://localhost:" + serverPort + "/test", String.class);
		assertEquals(response, "Hello, REST !!!!");
	}
	@Test
	public void testProductConrollerGetProductByIDPathVar()  {

		Product product = template.getForObject
				("http://localhost:" + serverPort + "/products/1", Product.class);
		assertEquals("fruits", product.getName());
		assertEquals(LocalDate.of(2021, 5, 8),product.getExpiresOn());
	}
	//for testing named query 
	@Test
	public void testProductConrollerGetProductByName()
	{
		Product product = template.getForObject
				("http://localhost:" + serverPort + "/products/name/biscuits", Product.class);
		assertEquals(120,product.getPrice());
	//	assertEquals(LocalDate.of(2020, 8, 12),product.getExpiresOn());
	}

}
