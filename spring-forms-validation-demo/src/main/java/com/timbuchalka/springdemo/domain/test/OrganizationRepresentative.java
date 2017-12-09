package com.timbuchalka.springdemo.domain.test;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class OrganizationRepresentative {
	
	@NotBlank(message="* First name cannot be blank")
	private String firstName;
	
	@NotEmpty(message="* Surname cannot be empty")
	@Size(min=3, max=10, message="* Surname: min 3 chars required, max 10 chars allowed")
	private String lastName;

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
