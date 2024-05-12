package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;

public class RestoreUserImage {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println("Enter user id to restore image ");
			int userId=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter file name with path");
			String fileName=sc.nextLine();
			
			System.out.println(dao.restoreImage(userId,fileName));
		} // sf.close() => immediate closing of cn pool
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
