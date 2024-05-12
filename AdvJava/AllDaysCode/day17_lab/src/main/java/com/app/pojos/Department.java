package com.app.pojos;
import javax.persistence.*;

@Entity
@Table(name = "dept_tbl")
public class Department extends BaseEntity {
	//name , location
	@Column(name="dept_name",length =20,unique = true )
	private String deptName;
	@Column(length = 30)
	private String location;
	public Department() {
		// TODO Auto-generated constructor stub
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Department [deptName=" + deptName + ", location=" + location + "]";
	}
	

}
