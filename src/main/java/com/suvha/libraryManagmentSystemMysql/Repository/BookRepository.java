package com.suvha.libraryManagmentSystemMysql.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suvha.libraryManagmentSystemMysql.model.Book;
@Repository
public interface BookRepository  extends JpaRepository<Book, Long>{
	public Optional<Book> findByName(String name);
	public Optional<Book> findById(long id);
	public Optional<Book> findByIsbn(String name);
	public List<Book> findByQuantityGreaterThan(int quantity);
}
