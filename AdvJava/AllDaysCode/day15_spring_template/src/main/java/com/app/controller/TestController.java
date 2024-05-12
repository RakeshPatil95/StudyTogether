package com.app.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // MANDATORY cls level anno to tell SC , following is req handling controller
//scope : singleton , eager
public class TestController {
	public TestController() {
		System.out.println("in ctor of " + getClass());
	}
	@PostConstruct
	public void anyInit()
	{
		System.out.println("in init ");
	}
	@RequestMapping("/hello")//MANDATORY method level anno to tell SC --following is req handling method 
	//to service get/post/put/delete/head/options.....
	public String test1()
	{
		System.out.println("in test1");
		return "/welcome";
	}
	
	@PreDestroy
	public void anyDestroy()
	{
		System.out.println("in destroy ");
	}
}
