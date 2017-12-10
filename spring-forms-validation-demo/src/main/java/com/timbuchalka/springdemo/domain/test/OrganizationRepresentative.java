package com.timbuchalka.springdemo.domain.test;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.timbuchalka.springdemo.validation.test.AgeConstraint;
import com.timbuchalka.springdemo.validation.test.EmailVerification;

public class OrganizationRepresentative {
	
	@NotBlank(message="* First name cannot be blank")
	private String firstName;
	
	@NotEmpty(message="* Surname cannot be empty")
	@Size(min=3, max=10, message="* Surname: min 3 chars required, max 10 chars allowed")
	private String lastName;
	
	@AgeConstraint(lower=20, upper=70, message="* Age range 20 to 70 only")
	private Integer age;
	
	@NotBlank(message="* Zipcode: cannot be empty")
	@Pattern(regexp="^[a-zA-Z0-9]{6}", message="* ZipCode: 6 characters and/or digits only")
	private String zipCode;
	
	@EmailVerification(message="* Email: is invalid")
	private String email;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

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
