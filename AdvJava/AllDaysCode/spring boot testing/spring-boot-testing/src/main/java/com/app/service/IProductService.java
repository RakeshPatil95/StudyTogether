package com.app.service;

import java.util.List;

import com.app.pojos.Product;

public interface IProductService {
	List<Product> getAllProducts();
	Product getProductById(int productId);
	Product addProduct(Product p);
	Product getProductByName(String name);
}
