package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.ProjectDaoImpl;
import pojos.Project;

public class GetProjectDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			ProjectDaoImpl dao = new ProjectDaoImpl();
			System.out.println("Enter project title ");
			String title = sc.next();
			Project project = dao.getProjectDetails(title);
			//in case of valid project title , project : DETACHED
			System.out.println("project details " + project);		
		} // sf.close() => immediate closing of cn pool
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
