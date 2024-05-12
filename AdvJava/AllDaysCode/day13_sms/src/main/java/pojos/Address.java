package pojos;

import javax.persistence.*;

@Entity
@Table(name = "adr_tbl")
public class Address extends BaseEntity {
	@Column(length = 30)
	private String city;
	@Column(length = 30)
	private String state;
	@Column(length = 30)
	private String country;
	// bi dir one to one relationship between entities
	//val of mappedBy -- name of the asso. prop as it appears in the owning side
	@OneToOne(mappedBy ="address")
	private Student student;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String city, String state, String country) {
		super();
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + ", country=" + country + ", getId()=" + getId() + "]";
	}

}
