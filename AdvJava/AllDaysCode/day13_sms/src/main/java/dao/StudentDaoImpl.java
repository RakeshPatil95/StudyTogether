package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import static utils.HibernateUtils.getFactory;

import pojos.Address;
import pojos.Student;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public String linkAddressDetails(long studentId, Address a) {
		String mesg = "linking address failed";
		// get Session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			// get student details
			Student s = session.get(Student.class, studentId);
			if (s != null) {
				s.setAddress(a);// student ---> adr
				a.setStudent(s);// adr --> student
				// s : persistent
				session.persist(a);
				mesg = "address linked ...";
			}
			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public Student getStudentDetails(String email) {
		Student student = null;
		String jpql = "select s from Student s where s.email=:email";
		// get Session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			student = session.createQuery(jpql, Student.class).setParameter("email", email).getSingleResult();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return student;
	}

}
