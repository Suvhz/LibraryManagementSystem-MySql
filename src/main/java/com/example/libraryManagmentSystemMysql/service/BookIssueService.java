package com.example.libraryManagmentSystemMysql.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.libraryManagmentSystemMysql.Repository.BookIssueRepository;
import com.example.libraryManagmentSystemMysql.Repository.BookRepository;
import com.example.libraryManagmentSystemMysql.model.Book;
import com.example.libraryManagmentSystemMysql.model.BookIssue;
import com.example.libraryManagmentSystemMysql.model.User;
import com.example.libraryManagmentSystemMysql.serviceDAO.ServiceDAO;
import com.suvha.libraryManagementSystem.exception.DataNotFoundException;

@Service
public class BookIssueService implements ServiceDAO<BookIssue>{
	
	@Autowired
	private BookIssueRepository bookIssueRepository;
	@Autowired
	private BookService bookService;
	@Autowired
	private UserService userService;
	@Override
	
	public BookIssue create(BookIssue t) {
		Book book = bookService.getById(t.getBookId());
		User user = userService.getById(t.getUserId());
		int quantity = book.getQuantity();
		if (user != null) {
			if (quantity > 0) {
				book.setQuantity(quantity - 1);
				bookService.update(book);
				t.setStatus(false);
				Date date = new Date();
				t.setIssueDate(date);
				return bookIssueRepository.save(t);
			}
		}
		throw new DataNotFoundException("Book with id " + t.getBookId() + " not found");
	}

	@Override
	public Map<String, String> delete(int id) {
		BookIssue bookIssue = getById(id);
		bookIssueRepository.delete(bookIssue);
		return Collections.singletonMap("response", "Deleted successfully");
	}

	@Override
	public void deleteAll() {
		bookIssueRepository.deleteAll();
		
	}

	@Override
	public BookIssue update(BookIssue t) {
		BookIssue bookIssue = getById(t.getId());
		bookIssue.setBookId(t.getBookId());
		bookIssue.setUserId(t.getUserId());
		bookIssue.setStatus(t.isStatus());
		return bookIssueRepository.save(bookIssue);
	}

	@Override
	public BookIssue getById(long id) {
		Optional<BookIssue> bookIssue = bookIssueRepository.findById(id);
		if (bookIssue.isPresent()) {
			return bookIssue.get();
		}
		throw new DataNotFoundException("BookIssue with id " + id + " not found");
	}

	@Override
	public List<BookIssue> getAll() {
		return bookIssueRepository.findAll();
	}


}
