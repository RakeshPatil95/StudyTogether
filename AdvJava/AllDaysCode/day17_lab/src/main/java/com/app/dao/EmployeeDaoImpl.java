package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements IEmployeeDao {
	// dependency :Entity Manager
	@Autowired
	private EntityManager mgr;

	@Override
	public List<Employee> getEmpsByDeptName(String deptName) {
		String jpql = "select e from Employee e where e.department.deptName=:nm";
		return mgr.createQuery(jpql, Employee.class).setParameter("nm", deptName)
				.getResultList();
	}

}