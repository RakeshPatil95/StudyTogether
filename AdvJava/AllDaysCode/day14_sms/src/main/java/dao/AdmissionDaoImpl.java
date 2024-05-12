package dao;

import static utils.HibernateUtils.getFactory;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Admission;
import pojos.Course;
import pojos.Student;

public class AdmissionDaoImpl implements IAdmissionDao {

	@Override
	public String admitNewStudent(Student student, String courseTitle) {
		String mesg = "student admission failed!!!!!!!!!!!!!!";
		String jpql = "select c from Course c where c.title=:title";// IN param name NEED NOT match with popjo prop name
		// get Session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			// 1 save student details
			session.persist(student);
			// 2. get course from it's title
			Course course = session.createQuery(jpql, Course.class).setParameter("title", courseTitle)
					.getSingleResult();
			// => course found
			// course : persistent student : persistent
			// 3 . Create admission : transient
			Admission newAdmission = new Admission(student, course);// newAdmission : transient
			session.persist(newAdmission);
			tx.commit();// hib auto dirty chking :2 insert query
			mesg = "Student :" + student.getName() + " admitted in the course with title " + courseTitle;
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public List<Student> getStudentsByCourse(String courseTitle) {
		List<Student> students = null;
		String jpql = "select a from Admission a  where a.course.title=:title";
		// get Session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			students = session.createQuery(jpql, Admission.class).setParameter("title", courseTitle).
					getResultStream() // Stream<Admission>
					.map(a -> a.getStudent()) // Stream<Student>
					.collect(Collectors.toList());
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return students;
	}

	@Override
	public List<Student> getAdmittedStudents() {
		List<Student> students = null;
		String jpql = "select a.student from Admission a";
		// get Session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			students = session.createQuery(jpql, Student.class).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return students;
	}

	@Override
	public List<Student> getStudentsByCourseOptimized(String courseTitle) {
		List<Student> students = null;
		 String jpql="select a from Admission a join fetch a.student where a.course.title=:title";
		// OR
//		String jpql = "select a.student from Admission a where a.course.title=:title";

		// get Session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
	//		students = session.createQuery(jpql, Student.class).setParameter("title", courseTitle).getResultList();
			students = session.createQuery(jpql, Admission.class).setParameter("title", courseTitle).
					getResultStream() // Stream<Admission>
					.map(a -> a.getStudent()) // Stream<Student>
					.collect(Collectors.toList());
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return students;
	}

}
