package com.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.pojos.Product;
import com.app.service.IProductService;

@SpringBootTest
class TestProductService {
	@Autowired
	private IProductService service;

	@Test
	public void testGetProductDetails()
	{
		Product p=service.getProductById(1);
		assertEquals(100, p.getPrice());
	}

}
