package com.app.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ProductSearchRequest {
	
	
	private String name;
	private double price;
	private LocalDate expiresOn;
	public ProductSearchRequest() {
		// TODO Auto-generated constructor stub
	}
	public ProductSearchRequest(String name, double price, LocalDate expiresOn) {
		super();
		this.name = name;
		this.price = price;
		this.expiresOn = expiresOn;
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
	
}
