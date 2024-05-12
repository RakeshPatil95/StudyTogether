package pojos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "projects_tbl")
public class Project extends BaseEntity {
	@Column(length = 100, unique = true)
	private String title;
	@Column(length = 100)
	private String technology;
	@Column(name = "completion_date")
	private LocalDate completionDate;
	// Project * ----> * Student : many to many , uni dir asso between 2 entities
	@ManyToMany//(fetch = FetchType.EAGER)
	@JoinTable(name = "projects_students", 
	joinColumns = @JoinColumn(name = "proj_id"), inverseJoinColumns = @JoinColumn(name = "stud_id"))
	private Set<Student> students = new HashSet<>();
	

	public Project() {
		// TODO Auto-generated constructor stub
	}

	public Project(String title, String technology, LocalDate completionDate) {
		super();
		this.title = title;
		this.technology = technology;
		this.completionDate = completionDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public LocalDate getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(LocalDate completionDate) {
		this.completionDate = completionDate;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Project [title=" + title + ", technology=" + technology + ", completionDate=" + completionDate
				+ ", getId()=" + getId() + "]";
	}

}
