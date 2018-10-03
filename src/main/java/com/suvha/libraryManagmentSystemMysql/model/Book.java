package com.suvha.libraryManagmentSystemMysql.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "book")
public class Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="Name cannot be null")
	@NotBlank(message="Enter the name")
	private String name;
	@Min(value=0, message="Please enter quantity greater than 0")
	private int quantity=0;
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
	@OneToMany(mappedBy="book", orphanRemoval=true)
	private List<BookIssue> bookIssue = new ArrayList<>();
	public Book(){
		
	}
	public Book(long id,  String name, int quantity, String location, String description,String isbn,String publisher, String author) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.location = location;
		this.description = description;
		this.isbn = isbn;
		this.publisher = publisher;
		this.author = author;
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
	
	
}
