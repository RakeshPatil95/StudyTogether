package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.AdmissionDaoImpl;
import dao.CourseDaoImpl;
import pojos.Course;
import static java.time.LocalDate.parse;

public class GetEnrolledStudentsByCourseOptimized {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			AdmissionDaoImpl dao=new AdmissionDaoImpl();
			System.out.println("Enter course title ");
			dao.getStudentsByCourseOptimized(sc.next()).forEach(System.out::println);
			} // sf.close() => immediate closing of cn pool
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
