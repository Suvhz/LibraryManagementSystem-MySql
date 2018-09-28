package com.example.libraryManagmentSystemMysql.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@NotNull(message="Name cannot be null")
	@NotBlank(message="Enter the name")
	private String name;
	@Min(value=1, message="Please enter quantity greater than 0")
	private int quantity;
	@NotNull(message="location cannot be null")
	@NotBlank(message="Enter the location")
	private String location;
	@NotNull(message="Description cannot be null")
	@NotBlank(message="Enter the description")
	private String description;
	@NotNull(message="ISBN cannot be null")
	@NotBlank(message="Enter the isbn")
	private String isbn;
	@NotNull(message="Publisher cannot be null")
	@NotBlank(message="Enter the publisher")
	private String publisher;
	@NotNull(message="Author cannot be null")
	@NotBlank(message="Enter the author")
	private String author;
	private String userId;
	
	public Book(){
		
	}
	public Book(long id,  String name, int quantity, String location, String description,String isbn,String publisher, String author, String userId) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.location = location;
		this.description = description;
		this.isbn = isbn;
		this.publisher = publisher;
		this.author = author;
		this.userId = userId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
