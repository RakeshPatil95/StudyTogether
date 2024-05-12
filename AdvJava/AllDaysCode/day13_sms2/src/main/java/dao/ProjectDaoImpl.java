package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Project;
import pojos.Student;

public class ProjectDaoImpl implements IProjectDao {

	@Override
	public String addNewProject(Project project) {
		String mesg = "Adding new project failed !!!!!!!!!!!!!";
		// get Session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			session.persist(project);
			tx.commit();
			mesg = "added new project with id=" + project.getId();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String addStudentToProject(String title, String email) {
		String mesg="adding student to project failed!!!!!!!!!!!1";
		String projectJPQL = "select p from Project p where p.title=:title";
		String studentJPQL = "select s from Student  s where s.email=:em";

		// get Session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			// get persistent project from it's title
			Project project = session.createQuery(projectJPQL, Project.class).setParameter("title", title)
					.getSingleResult();
			Student student = session.createQuery(studentJPQL, Student.class).setParameter("em", email)
					.getSingleResult();
			//project n student : PERSISTENT , BUT no link established yet!!!!!!!!!!!
			project.getStudents().add(student);//adding the ref to the set
			tx.commit();
			mesg="added student "+student.getName()+" to the project with title "+title;
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public Project getProjectDetails(String title) {
		Project project=null;
		// get Session from SF
		String projectJPQL = "select p from Project p where p.title=:title";
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			project = session.createQuery(projectJPQL, Project.class).setParameter("title", title)
					.getSingleResult();
			//project : PERSISTENT
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return project;//dao layer rets DETACHED pojo ref to the caller.
	}
	@Override
	public Project getProjectAndStudentDetails(String title) {
		Project project=null;
		// get Session from SF
		String projectJPQL = "select p from Project p where p.title=:title";
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			project = session.createQuery(projectJPQL, Project.class).setParameter("title", title)
					.getSingleResult();
			//project : PERSISTENT
			//Till now has it lifted data from students table ? NO 
		//	System.out.println(project.getStudents());
			project.getStudents().size();//Hint ! ---simply access the size of the collection in PERSISTENT mode 
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return project;//dao layer rets DETACHED pojo ref to the caller.
	}
	@Override
	public Project getProjectAndStudentDetailsJoinFetch(String title) {
		Project project=null;
		// get Session from SF
		String projectJPQL = "select p from Project p join fetch p.students where p.title=:title";
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			project = session.createQuery(projectJPQL, Project.class).setParameter("title", title)
					.getSingleResult();
			//project : PERSISTENT
				tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return project;//dao layer rets DETACHED pojo ref to the caller.
	}
	
	
	

}
