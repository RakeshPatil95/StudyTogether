package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	public HomeController() {
		System.out.println("in ctor of "+getClass());
	}
	//add req handling method to show home page(login.jsp)
	@GetMapping("/")
	public String showHomePage()
	{
		System.out.println("in show home page");
		return "/index";//AVN : /WEB-INF/views/index.jsp
	}

}
