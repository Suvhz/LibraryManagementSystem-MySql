package com.example.libraryManagmentSystemMysql.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.libraryManagmentSystemMysql.model.Book;
@Repository
public interface BookRepository  extends JpaRepository<Book, Long>{

}
