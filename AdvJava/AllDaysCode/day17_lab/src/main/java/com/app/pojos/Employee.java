package com.app.pojos;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name="emp_tbl")
public class Employee extends BaseEntity{
//name adr salary joindate + Department dept
	@Column(length = 20)
	private String name;
	@Column(length = 40)
	private String address;
	private double salary;
	@Column(name="join_date")
	private LocalDate joinDate;
	//Many to One uni dir asso Dept 1<----- *Emp
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="dept_id")
	private Department department;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public LocalDate getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", address=" + address + ", salary=" + salary + ", joinDate=" + joinDate
				+ "]";
	}
	
}
