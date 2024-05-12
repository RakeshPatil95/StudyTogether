package dao;

import pojos.Role;
import pojos.User;
import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.*;

public class UserDaoImpl implements IUserDao {

	@Override
	public String saveUser(User user) {
		// get hibernate session from SF using openSession API
		Session session = getFactory().openSession(); // L1 cache created along with hib session n db conn pooled out
		Session session2 = getFactory().openSession();
		System.out.println(session.getClass());
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
		// user : TRANSIENT -- exists only in heap , neither in
		// L1 cache nor in DB
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
			session.save(user);// user : PERSISTENT -- part of L1 cache BUT rec not yet inserted in DB
			// => success --commit
			tx.commit();// Hibernate performs : auto dirty chking (=flushing the session on DB) --- hib
						// fires insert query (DML)
			// close session -- destroys L1 cache-- pooled out db cn rets to the pool.
			System.out.println("is open " + session.isOpen() + " is connected " + session.isConnected());// f f

		} catch (RuntimeException e) {
			// failure -- rollback
			if (tx != null)
				tx.rollback();
			System.out.println("is open " + session.isOpen() + " is connected " + session.isConnected());// f f
			throw e;// re throwing SAME exc to the caller for info.
		}
		// user : DETACHED
		return "User details inserted with user ID " + user.getUserId();
	}

	@Override
	public User getUserDetails(int userId) {
		User user = null;// user : does not exist!
		// get Session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			// API of Session : public <T> T get(Class<T> cls, Serializable id) throws
			// HibernateExc
			user = session.get(User.class, userId);// in case of valid id --user : PERSISTENT , has a corresponding rec
													// in DB n it's part of L1 cache
			user = session.get(User.class, userId);
			user = session.get(User.class, userId);
			user = session.get(User.class, userId);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return user;
	}

	@Override
	public List<User> getAllUserDetails() {
		List<User> users = null;
		// get Session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery("select u from User u", User.class).getResultList();
//			users = session.createQuery("select u from User u", User.class).getResultList();
//			users = session.createQuery("select u from User u", User.class).getResultList();
			// users -- list of PERSISTENT entities(part of L1 cache n has DB identity)
			tx.commit();// auto dirty chking --no DMLs -- L1 cache destroyed , session closed --rets
						// pooled out db cn to the pool
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return users;// users -- list of DETACHED entities
	}

	@Override
	public List<User> getSelectedUsers(LocalDate startDate, LocalDate endDate, Role role1) {
		String jpql = "select u from User u where u.regDate between :start and :end and u.userRole=:role";
		List<User> users = null;
		// get Session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class).setParameter("start", startDate).setParameter("end", endDate)
					.setParameter("role", role1).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return users;
	}

	@Override
	public List<String> getSelectedUserNames(LocalDate start) {
		String jpql = "select u.name from User u where u.regDate > :dt";
		List<String> names = null;
		// get Session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			names = session.createQuery(jpql, String.class).setParameter("dt", start).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return names;
	}

	@Override
	public List<User> getSelectedUserDetails(LocalDate start) {
		String jpql = "select new pojos.User(name,email,regAmount,regDate) from User u where u.regDate > :dt";
		List<User> users = null;
		// get Session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class).setParameter("dt", start).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return users;
	}

	@Override
	public String changePassword(String email, String oldPwd, String newPwd) {
		String mesg = "Password updating failed....";
		String jpql = "select u from User u where u.email=:em and u.password=:pass";
		// get Session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		User u = null;
		try {
			u = session.createQuery(jpql, User.class).setParameter("em", email).setParameter("pass", oldPwd)
					.getSingleResult();// in case of invalid login -- throws javax.persistence.NoResultExc
			// => valid login , u : PERSISTENT
			u.setPassword(newPwd);// modifying state of the PERSISTENT entity in L1 cache
			tx.commit();// hib perform auto dirty chking --session.flush -- DML : update --- session
						// closed
			mesg = "Password updated....";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		u.setPassword("334455");// u : DETACHED , i.e modifying state of the DETACHED entity--hib CAN NOT
								// propagate the changes to db
		return mesg;
	}

	@Override
	public String applyBulkDiscount(LocalDate date, double discount) {
		String mesg = "Bulk updation failed!!!!!!!!!!!!";
		String jpql = "update User u set u.regAmount=u.regAmount-:disc where u.userRole=:role and u.regDate< :dt";
		// get Session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			int updateCount = session.createQuery(jpql).setParameter("disc", discount)
					.setParameter("role", Role.CUSTOMER).setParameter("dt", date).executeUpdate();
			// L1 cache : EMPTY (i.e update query by passes the cache!)
			tx.commit();
			mesg = updateCount + " users got discount....";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String deleteUserDetails(int userId) {
		String mesg = "Un subscription failed : invalid user id !!!!!!!!!!!!!!";
		// get Session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			// get user from it's id
			User user = session.get(User.class, userId);// int --> Integer ---> up casting --> Serializable
			if (user != null) {
				// user : PERSISTENT
				session.delete(user); // entity is simply marked for removal! : user --REMOVED
				mesg = "User with name " + user.getName() + " un -subscribed....";
			}
			tx.commit();// session.flush --auto dirty chking --delete query --rec is deleted from DB ,
						// session.close=> L1 cache is destroyed , DB cn rets to the pool
			// user : TRANSIENT

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return mesg;
	}// Are there any objs marked for GC ? YES (user)

	@Override
	public String bulkDeleteUsers(LocalDate date, double amount) {
		String mesg = "Bulk Deletion failed !!!!!!!!!!!!";
		String jpql = "delete from User u where u.regDate > :dt and u.regAmount < :amt";
		// get Session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			int updateCount = session.createQuery(jpql).
					setParameter("dt", date).setParameter("amt", amount)
					.executeUpdate();
			tx.commit();
			mesg=updateCount+" users deleted.....";

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}
