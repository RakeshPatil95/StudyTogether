package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
//salary , joinDate , lastName (Treat earlier name as first name : unique),password,email


@Getter
@Setter
@ToString
@Entity
@Table(name="emps")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private Integer empId;
	@NotEmpty(message = "First name must be supplied")
	@Length(min = 4,max=30,message = "Invalid First name length")
	@Column(length = 30)
	private String name;	
	@Column(length = 30)
	@NotBlank(message = "Last name must be supplied")
	private String lastName;
	@Column(length = 30)
	@NotBlank
	@Email(message = "Invalid Email")
	private String email;
	@Column(length = 30)
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})")
	private String password;
	@Column(length = 30)
	@NotBlank(message = "depatment is required")
	private String department;
	@JsonProperty("location")
	@Column(length = 30)
	@NotBlank(message = "work location is required")
	private String workLocation;
	@Range(min = 10000,max=50000,message = "Invalid salary")
	private double salary;
	@Future(message = "join date msut be in future")
	private LocalDate joinDate;
	
}
