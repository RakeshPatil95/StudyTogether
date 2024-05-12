package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import pojos.Address;

public class LinkStudentAddress {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			StudentDaoImpl dao=new StudentDaoImpl();
			System.out.println("Enter student id");
			long sid=sc.nextLong();
			System.out.println("Enter adr details : city,  state,  country");
			System.out.println(dao.linkAddressDetails(sid, new Address(sc.next(), sc.next(), sc.next())));
		} // sf.close() => immediate closing of cn pool
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
