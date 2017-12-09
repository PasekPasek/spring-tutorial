package com.timbuchalka.springdemo.domain.test;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.timbuchalka.springdemo.validation.test.AgeConstraint;

public class OrganizationRepresentative {
	
	@NotBlank(message="* First name cannot be blank")
	private String firstName;
	
	@NotEmpty(message="* Surname cannot be empty")
	@Size(min=3, max=10, message="* Surname: min 3 chars required, max 10 chars allowed")
	private String lastName;
	
	@AgeConstraint
	private Integer age;

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
