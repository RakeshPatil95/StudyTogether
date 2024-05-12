package pojos;

import java.time.LocalDate;

import javax.persistence.*;

/*
 * Properties of Admission : admissionId , date , student , course , status
 */
@Entity
@Table(name = "admissions_tbl", uniqueConstraints = @UniqueConstraint(columnNames = { "student_id", "course_id" }))
public class Admission extends BaseEntity {
	@Column(name = "admission_date")
	private LocalDate admissionDate;
	// Admission HAS-A Student (i.e linked with Student)
	@ManyToOne // => 1 student can take multiple admissions to different courses
	// Student 1<-----* Admission
	@JoinColumn(name = "student_id") // to specify name of the FK col to hibernate
	private Student student;
	// Admission HAS-A Course (i.e linked with Course)
	@ManyToOne// => 1 course can have multiple admissions for different students
	@JoinColumn(name = "course_id")
	// Course 1 <----- * Admission
	private Course course;
	@Enumerated(EnumType.STRING)
	@Column(length = 50)
	private Status status;

	public Admission() {
		// TODO Auto-generated constructor stub
	}

	public Admission(Student student, Course course) {
		super();
		this.student = student;
		this.course = course;
		this.admissionDate = LocalDate.now();
		this.status = Status.STUDENT_ADMITTED;
	}

	// all setters n getters
	public LocalDate getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	// Project Tip : DO NOT add any association fields in toString
	@Override
	public String toString() {
		return "Admission [admissionDate=" + admissionDate + ", status=" + status + ", getId()=" + getId() + "]";
	}

}
