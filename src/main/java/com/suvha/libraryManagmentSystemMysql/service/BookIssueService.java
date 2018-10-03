package com.suvha.libraryManagmentSystemMysql.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suvha.libraryManagmentSystemMysql.Repository.BookIssueRepository;
import com.suvha.libraryManagmentSystemMysql.exception.DataNotFoundException;
import com.suvha.libraryManagmentSystemMysql.model.Book;
import com.suvha.libraryManagmentSystemMysql.model.BookIssue;
import com.suvha.libraryManagmentSystemMysql.model.User;
import com.suvha.libraryManagmentSystemMysql.serviceDAO.ServiceDAO;

@Service
public class BookIssueService implements ServiceDAO<BookIssue>{
	
	@Autowired(required=true)
	private BookIssueRepository bookIssueRepository;
	@Autowired(required=true)
	private BookService bookService;
	@Autowired(required=true)
	private UserService userService;
	
	@Override
	public BookIssue create(BookIssue t) {
		Book book = bookService.getById(t.getBook().getId());
		User user = userService.getById(t.getUser().getId());
		int quantity = book.getQuantity();
		if (user != null) {
			if (quantity > 0) {
				t.setStatus(false);
				t.setUser(user);
				Date date = new Date();
				t.setIssueDate(date);
				book.setQuantity(quantity--);
				bookService.update(book);
				return bookIssueRepository.save(t);
			}
		}
		throw new DataNotFoundException("Book with id " + t.getBook() + " not found");
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
		Book book = bookService.getById(bookIssue.getId());
		bookIssue.setBook(t.getBook());
		bookIssue.setStatus(t.isStatus());
		Date date = new Date();
		bookIssue.setDueDate(date);
		book.setQuantity(book.getQuantity()+1);
		bookService.update(book);
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
