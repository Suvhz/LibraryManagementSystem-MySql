package com.suvha.libraryManagmentSystemMysql.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suvha.libraryManagmentSystemMysql.model.BookIssue;
@Repository
public interface BookIssueRepository extends JpaRepository<BookIssue, Long>{

}
