package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.IEmployeeDao;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	// dep : emp dao i/f
	@Autowired
	private IEmployeeDao empDao;

	public EmployeeController() {
		System.out.println("in ctor of " + getClass());
	}

	// add req handling method for getting emps by dept name
	@GetMapping("/list")
	public String listEmpsByDept(@RequestParam String deptName, Model map)

	{
		System.out.println("dept name "+deptName);
		map.addAttribute("emp_list",empDao.getEmpsByDeptName(deptName));
		return "/list";//AVN : /WEB-INF/views/list.jsp
	}

}
