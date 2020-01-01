package com.ace.dto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan
@Entity(name="Person")
@Table(schema="batchdemo",name="person")
@NamedNativeQueries(
		value= {
				@NamedNativeQuery(
						//name= entityname.queryName
						name = "Person.updateMobile",
						query = "update person set mobile = :mobile  where person_id = :person_id"
						)
				}
		)


public class Person {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="person_id")
	private int personId;
	@Column(name="first_name",nullable=false)
	private String firstName;
	@Column(name="last_name",nullable=false)
	private String lastName;
	@Column(name="age",nullable=false)
	private int age;
	@Column(name="mobile",nullable=false)
	private String mobile;
	@Column(name="email",nullable=false)
	private String email;
	
	
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
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
	
	

}
