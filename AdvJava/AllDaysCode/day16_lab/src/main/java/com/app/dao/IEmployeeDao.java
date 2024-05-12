package com.app.dao;

import java.util.List;

import com.app.pojos.Employee;

public interface IEmployeeDao {
//add a method to ret emps by dept name
	List<Employee> getEmpsByDeptName(String deptName);
}
