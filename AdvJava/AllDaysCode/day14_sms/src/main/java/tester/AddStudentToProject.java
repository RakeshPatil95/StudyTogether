package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.ProjectDaoImpl;

public class AddStudentToProject {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory();Scanner sc=new Scanner(System.in)) {
			ProjectDaoImpl dao=new ProjectDaoImpl();
			System.out.println("Enter project title n student's email");
			System.out.println(dao.addStudentToProject(sc.next(), sc.next()));
		}//sf.close() => immediate closing of cn pool
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
