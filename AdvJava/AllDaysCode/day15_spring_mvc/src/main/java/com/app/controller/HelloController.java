package com.app.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //mandatory
//singleton n eager spring bean : req handling logic : req handler spring bean
public class HelloController {
	public HelloController() {
		System.out.println("in ctor of "+getClass());
	}
	@PostConstruct
	public void myInit()
	{
		System.out.println("in init ....");
	}
	@RequestMapping("/hello")//mandatory
	public String sayHello()
	{
		System.out.println("in say hello");
		return "/welcome";
	}
	@PreDestroy
	public void myDestroy()
	{
		System.out.println("in dest ....");
	}
	
	

}
