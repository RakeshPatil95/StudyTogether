package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import pojos.Employee;

public interface IEmployeeDao {
	/*
	 * Display emp details(id name salary joindate) from a specific department ,
	 * joined after specific date , sorted details as per salary asc
	 */
	List<Employee> getEmpDetailsByDeptAndDate(String dept, Date joinDate) throws SQLException;

}
