package com.suvha.libraryManagmentSystemMysql.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suvha.libraryManagmentSystemMysql.model.BookIssue;

public interface BookIssueRepository extends JpaRepository<BookIssue, Long>{

}
