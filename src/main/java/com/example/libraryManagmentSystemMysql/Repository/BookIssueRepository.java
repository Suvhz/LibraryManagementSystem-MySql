package com.example.libraryManagmentSystemMysql.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.libraryManagmentSystemMysql.model.BookIssue;

public interface BookIssueRepository extends JpaRepository<BookIssue, Long>{

}
