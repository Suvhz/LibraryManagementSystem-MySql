package com.example.libraryManagmentSystemMysql.model;

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
	public String id;
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
	public User(String id,
			@NotNull(message = "First name cannot be null") @NotBlank(message = "Enter first name") String firstName,
			@NotNull(message = "Last name cannot be null") @NotBlank(message = "Enter last name") String lastName,
			@Email(message = "Enter email") String email, @NotNull String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
}
