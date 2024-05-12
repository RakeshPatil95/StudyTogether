package com.app.dao;

import com.app.pojos.User;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // Mandatory anno to tell SC , following is DAO layer n enables exc translation
			// mechanism
//chked sql exc ---> un chked hib exc ---> un chked spring platform based exc
public class UserDaoImpl implements IUserDao {
	// dependency : SF
	@Autowired // autowire=byType (field level D.I)
	private SessionFactory sf;

	@Override
	public User validateUser(String email, String password) {
		String jpql = "select u from User u where u.email=:em and u.password=:pass";
		// no boilerplate code : since tx management is delegated to spring supplied :
		// TxMgr bean(configured in hib persistence xml)
		return sf.getCurrentSession().createQuery(jpql, User.class).setParameter("em", email)
				.setParameter("pass", password).getSingleResult();
	}

}
