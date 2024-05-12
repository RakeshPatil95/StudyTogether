package pojos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 1. Properties of Student
studentId,name,email, status
status : ADMISSION_CANCELLED, STUDENT_ADMITTED
 */
import javax.persistence.*;

@Entity
@Table(name = "students_tbl")
public class Student extends BaseEntity {
	@Column(length = 30)
	private String name;
	@Column(length = 30, unique = true)
	private String email;
	@Enumerated(EnumType.STRING)
	@Column(length = 50)
	private Status status;
	// add asso between Student n AdharCard
	@Embedded // OPTIONAL , added only for the understanding
	private AdharCard card;
	// Student HAS-A hobbies
	@ElementCollection // MANDATORY to specify that following is a collection of basic type
	@CollectionTable(name = "my_hobbies", joinColumns = @JoinColumn(name = "student_id")) // OPTIONAL BUT Reco !
	@Column(name = "hobby", length = 40)
	private List<String> hobbies = new ArrayList<>();
	// Student HAS-A edu. qualifications
	@ElementCollection // MANDATORY to specify that following is a collection of composite type (UDT)
	@CollectionTable(name = "student_qualifications", joinColumns = @JoinColumn(name = "student_id"))
	private Set<EducationalQualification> qualifications = new HashSet<>();

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

	public AdharCard getCard() {
		return card;
	}

	public void setCard(AdharCard card) {
		this.card = card;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	public Set<EducationalQualification> getQualifications() {
		return qualifications;
	}

	public void setQualifications(Set<EducationalQualification> qualifications) {
		this.qualifications = qualifications;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", email=" + email + ", status=" + status + ", getId()=" + getId() + "]";
	}

}
