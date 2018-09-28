package com.suvha.libraryManagmentSystemMysql.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suvha.libraryManagmentSystemMysql.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
