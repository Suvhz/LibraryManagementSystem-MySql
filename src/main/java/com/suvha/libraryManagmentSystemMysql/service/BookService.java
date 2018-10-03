package com.suvha.libraryManagmentSystemMysql.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suvha.libraryManagmentSystemMysql.Repository.BookRepository;
import com.suvha.libraryManagmentSystemMysql.exception.DataNotFoundException;
import com.suvha.libraryManagmentSystemMysql.model.Book;
import com.suvha.libraryManagmentSystemMysql.serviceDAO.ServiceDAO;
@Service
public class BookService implements ServiceDAO<Book>{
	
	@Autowired
	private BookRepository bookRepository;
	@Override
	public Book create(Book t) {
		return bookRepository.save(t);
	}

	@Override
	public Map<String, String> delete(int id) {
		Book book = getById(id);
		bookRepository.delete(book);
		return Collections.singletonMap("response", "Deleted successfully");
	}

	@Override
	public void deleteAll() {
		bookRepository.deleteAll();
		
	}

	@Override
	public Book update(Book t) {
		Book findedBook = getById(t.getId());
		findedBook.setName(t.getName());
		findedBook.setAuthor(t.getAuthor());
		findedBook.setDescription(t.getDescription());
		findedBook.setLocation(t.getLocation());
		findedBook.setQuantity(t.getQuantity());
		findedBook.setIsbn(t.getIsbn());
		findedBook.setPublisher(t.getPublisher());
		return bookRepository.save(findedBook);
	}
	@Override
	public Book getById(long id) {
		Optional<Book> bookOptional = bookRepository.findById(id);
		if (bookOptional.isPresent()) {
			return bookOptional.get();
		}
		throw new DataNotFoundException("Book with id " + id + " not found");

	}

	@Override
	public List<Book> getAll() {
		return bookRepository.findAll();
	}
	public List<Book> get(){
		return bookRepository.findByQuantityGreaterThan(0);
	}
	public Book getByBookName(String bookName) {
		Book book = bookRepository.findByName(bookName);
		if (book != null) {
			return book;
		}
		throw new DataNotFoundException("Book with name " + bookName + " not found");
	}

}
