package com.example.libraryManagmentSystemMysql.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.libraryManagmentSystemMysql.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
