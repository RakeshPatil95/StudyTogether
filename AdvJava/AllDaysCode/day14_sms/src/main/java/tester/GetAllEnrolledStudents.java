package tester;

import static utils.HibernateUtils.getFactory;

import org.hibernate.SessionFactory;

import dao.AdmissionDaoImpl;

public class GetAllEnrolledStudents {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory()) {
			AdmissionDaoImpl dao = new AdmissionDaoImpl();
			dao.getAdmittedStudents().forEach(System.out::println);
		} // sf.close() => immediate closing of cn pool
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
