package com.example.libraryManagmentSystemMysql.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

import lombok.Data;
@Entity
@Data
public class BookIssue {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
	private String userId;
	private String bookId;
	private boolean status;
	
	public BookIssue() {}
	
	public BookIssue(String userId, String bookId, boolean status) {
		this.userId = userId;
		this.bookId = bookId;
		this.status = status;
	}
	
}
