package com.suvha.libraryManagmentSystemMysql.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import lombok.Data;
@Entity
@Data
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long id;
	@NotNull(message="First name cannot be null")
	@NotBlank(message="Enter first name")
	private String firstName;
	@NotNull(message="Last name cannot be null")
	@NotBlank(message="Enter last name") 
	private String lastName;
	@Email(message="Enter email")
	private String email;
	@NotNull
	private String password;
	public User() {
		
	}
	public User(String firstName, String lastName, String email,String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
