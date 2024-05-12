package dao;

import pojos.User;
import static utils.HibernateUtils.getFactory;

import org.hibernate.*;

public class UserDaoImpl implements IUserDao {

	@Override
	public String saveUser(User user) {
		// get hibernate session from SF using openSession API
		Session session = getFactory().openSession(); // L1 cache created along with hib session n db conn pooled out
		Session session2 = getFactory().openSession();
		System.out.println("same sessions? " + (session == session2));// f
		// begin hibernate transaction(tx)
		Transaction tx = session.beginTransaction();
		System.out.println("is open " + session.isOpen() + " is connected " + session.isConnected());// t t
		try {
			// Session API : public Serializable save(Object entity)
			session.save(user);
			// => success --commit
			tx.commit();// hib fires insert query (DML)
			System.out.println("is open " + session.isOpen() + " is connected " + session.isConnected());// t t

		} catch (RuntimeException e) {
			// failure -- rollback
			if (tx != null)
				tx.rollback();
			throw e;// re throwing SAME exc to the caller for info.
		} finally {
			if (session != null)
				session.close();// L1 cache is destroyed n pooled out db cn , rets to the pool
		}
		System.out.println("is open " + session.isOpen() + " is connected " + session.isConnected());// f f

		return "User details inserted with user ID " + user.getUserId();
	}

	@Override
	public String saveUserWithGetCurntSession(User user) {
		// get hibernate session from SF using getCurrentSession API
		Session session = getFactory().getCurrentSession(); // L1 cache created along with hib session n db conn pooled
															// out
		Session session2 = getFactory().getCurrentSession();
		System.out.println("same sessions? " + (session == session2));// t
		// begin hibernate transaction(tx)
		Transaction tx = session.beginTransaction();
		System.out.println("is open " + session.isOpen() + " is connected " + session.isConnected());// t t
		try {
			// Session API : public Serializable save(Object entity)
			session.save(user);
			// => success --commit
			tx.commit();// hib fires insert query (DML)
			System.out.println("is open " + session.isOpen() + " is connected " + session.isConnected());// f f

		} catch (RuntimeException e) {
			// failure -- rollback
			if (tx != null)
				tx.rollback();
			System.out.println("is open " + session.isOpen() + " is connected " + session.isConnected());// f f
			throw e;// re throwing SAME exc to the caller for info.
		}
		return "User details inserted with user ID " + user.getUserId();
	}

}
