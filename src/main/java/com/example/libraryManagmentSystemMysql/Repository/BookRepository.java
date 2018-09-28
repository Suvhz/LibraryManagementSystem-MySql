package com.example.libraryManagmentSystemMysql.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.libraryManagmentSystemMysql.model.Book;
@Repository
public interface BookRepository  extends JpaRepository<Book, Long>{
	public Book findByName(String name);
	public Optional<Book> findById(long id);
	public List<Book> findByQuantityGreaterThan(int quantity);

}
