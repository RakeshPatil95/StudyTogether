package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
import pojos.Role;
import pojos.User;

public class TestSaveVsPersist {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			// create user dao instance
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println(
					"Enter user details  name,  email,  password,  confirmPassword,  userRole,  regAmount	 regDate(yr-mon-day)");
			User user = new User(sc.next(), sc.next(), sc.next(), sc.next(), Role.valueOf(sc.next().toUpperCase()),
					sc.nextDouble(), LocalDate.parse(sc.next()));// user : TRANSIENT -- exists only in heap , neither in
																	// L1 cache nor in DB
			user.setUserId(100);
			System.out.println(dao.saveUserWithGetCurntSession(user));
		} // sf.close() => immediate closing of cn pool
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
