package dao;

import java.util.List;

import pojos.Student;

public interface IAdmissionDao {
	//student admission
	String admitNewStudent(Student student , String courseTitle);
	//get student details for a particular course
	List<Student> getStudentsByCourse(String courseTitle);
	//get student details for a particular course in optimized manner
		List<Student> getStudentsByCourseOptimized(String courseTitle);
	//get admitted student details
	List<Student> getAdmittedStudents();

}
