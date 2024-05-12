package dao;

import pojos.Project;

public interface IProjectDao {
	String addNewProject(Project project);
	String addStudentToProject(String title,String email);
	Project getProjectDetails(String title);
	Project getProjectAndStudentDetails(String title);
	Project getProjectAndStudentDetailsJoinFetch(String title);
}
