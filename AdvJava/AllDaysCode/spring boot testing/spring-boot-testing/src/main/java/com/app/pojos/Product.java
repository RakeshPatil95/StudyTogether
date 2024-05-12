package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Product.findByName", query = "select p from Product p where p.name=:nm")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	@Column(length = 20, unique = true)
	private String name;
	private double price;
	@Column(name = "expiry")
	private LocalDate expiresOn;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String name, double price, LocalDate expiresOn) {
		super();

		this.name = name;
		this.price = price;
		this.expiresOn = expiresOn;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getExpiresOn() {
		return expiresOn;
	}

	public void setExpiresOn(LocalDate expiresOn) {
		this.expiresOn = expiresOn;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", price=" + price + ", expiresOn=" + expiresOn
				+ "]";
	}

}
