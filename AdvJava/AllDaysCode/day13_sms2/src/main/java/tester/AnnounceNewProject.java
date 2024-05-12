package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.ProjectDaoImpl;
import pojos.Project;

public class AnnounceNewProject {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			ProjectDaoImpl dao = new ProjectDaoImpl();
			System.out.println("Enter project details : title,  technology,  completionDate");
			System.out.println(dao.addNewProject(new Project(sc.next(), sc.next(), LocalDate.parse(sc.next()))));
		} // sf.close() => immediate closing of cn pool
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
