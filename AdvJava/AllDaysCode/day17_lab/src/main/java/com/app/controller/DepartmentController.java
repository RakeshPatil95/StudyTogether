package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.dao.IDepartmentDao;

@Controller
public class DepartmentController {
	//dependency : dao layer i/f
	@Autowired
	private IDepartmentDao departmentDao;
	public DepartmentController() {
		System.out.println("in ctor of "+getClass());
	}
	//add req handling method to get list of dept names
	@GetMapping("/")
	public String getAllDeptNames(Model map)
	{
		System.out.println("in get all dept nms");
		map.addAttribute("dept_names", departmentDao.getAllDepartments());
		return "/dept";//AVN : /WEB-INF/views/dept.jsp
		
	}

}
