package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DepartmentDaoImpl implements IDepartmentDao {
	//dependency : SF
	@Autowired
	private SessionFactory sf;

	@Override
	public List<String> getAllDepartments() {
		String jpql="select d.deptName from Department d";
		return sf.getCurrentSession().createQuery(jpql, String.class).getResultList();
	}

}
