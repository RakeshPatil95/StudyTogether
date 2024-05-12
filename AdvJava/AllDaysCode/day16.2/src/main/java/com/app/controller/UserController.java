package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Role;
import com.app.pojos.User;
import com.app.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	// dependency : service layer i/f
	@Autowired
	private IUserService userService;

	public UserController() {
		System.out.println("in ctor of " + getClass());
	}

	// add req handling method to show login form
	@GetMapping("/login")
	public String showLoginForm() {
		System.out.println("in show login form");
		return "/user/login";// AVN : /WEB-INF/views/user/login.jsp
	}

	// add req handling method for processing login form
	// entry in Handler Mapping bean
	// key : /user/login + method=POST +.....
	// value : com.app.controller.UserController.processLoginForm
	@PostMapping("/login")
	public String processLoginForm(@RequestParam String email, @RequestParam("pass") String pwd, Model map)
	// reco : MATCH req param names to method arg names for easy binding
	// SC : String pwd=request.getParameter("pass");
	{
		System.out.println("in process login form " + email + " " + pwd + " " + map);
		try {
			// invoke service layer method
			User user = userService.authenticateUser(email, pwd);
			map.addAttribute("mesg",
					"Login Successful, Hello , " + user.getName() + " , logged in under " + user.getRole() + " role");
			// => valid login --proceed to authorization
			if (user.getRole() == Role.CUSTOMER)
				return "/customer/topics";
			// => admin login success
			return "/admin/status";
		} catch (RuntimeException e) {
			System.out.println("err in " + getClass() + " exc " + e);
			map.addAttribute("mesg", "Invalid Login , Please retry !!!!!!!!!!!!!");
			return "/user/login";// AVN : /WEB-INF/views/user/login.jsp
		}
		
	}

}
