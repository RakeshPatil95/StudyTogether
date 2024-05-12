package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.ProjectDaoImpl;
import pojos.Project;

public class GetProjectAndStudentDetailsWithJoinFetch {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			ProjectDaoImpl dao = new ProjectDaoImpl();
			System.out.println("Enter project title ");
			String title = sc.next();
			Project project = dao.getProjectAndStudentDetailsJoinFetch(title);
			//in case of valid project title , project : DETACHED
			System.out.println("project details " + project);
			System.out.println("Student details from Project " + title);
			project.getStudents().forEach(System.out::println);
		} // sf.close() => immediate closing of cn pool
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
