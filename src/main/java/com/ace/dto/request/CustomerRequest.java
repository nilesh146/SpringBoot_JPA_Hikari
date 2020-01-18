package com.ace.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.ace.validators.Phone;

public class CustomerRequest extends DomainRequest{

	@NotNull(message = "firstName cannot be null")
	@NotBlank
	private String firstName;

	@NotNull(message = "lastName cannot be null")
	@NotBlank
	private String lastName;

	@NotNull(message = "middleName cannot be null")
	@NotBlank
	private String middleName;

	private int age;

	//@Phone(nullable = false, empty = false)
	private String mobile;

	@NotNull(message = "email cannot be null")
	@NotBlank
	private String email;

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "CustomerRequest [firstName=" + firstName + ", lastName=" + lastName + ", middleName=" + middleName
				+ ", age=" + age + ", mobile=" + mobile + ", email=" + email + "]";
	}

}
