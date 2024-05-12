package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.AdmissionDaoImpl;
import dao.CourseDaoImpl;
import pojos.Course;
import pojos.Student;

import static java.time.LocalDate.parse;

public class NewStudentSAdmission {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			AdmissionDaoImpl dao = new AdmissionDaoImpl();
			System.out.println("Enter student details : name email");
			Student s1 = new Student(sc.next(), sc.next());
			System.out.println("Enter course title");
			System.out.println(dao.admitNewStudent(s1, sc.next()));
		} // sf.close() => immediate closing of cn pool
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
