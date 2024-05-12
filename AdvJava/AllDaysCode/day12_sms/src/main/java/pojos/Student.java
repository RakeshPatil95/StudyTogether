package pojos;

/*
 * 1. Properties of Student
studentId,name,email, status
status : ADMISSION_CANCELLED, STUDENT_ADMITTED
 */
import javax.persistence.*;
@Entity
@Table(name="students_tbl")
public class Student extends BaseEntity {
	@Column(length = 30)
	private String name;
	@Column(length = 30,unique = true)
	private String email;
	@Enumerated(EnumType.STRING)
	@Column(length = 50)
	private Status status;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String email) {
		super();
		this.name = name;
		this.email = email;
		this.status = Status.STUDENT_ADMITTED;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", email=" + email + ", status=" + status + ", getId()=" + getId() + "]";
	}

}
