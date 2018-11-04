package com.suvha.libraryManagmentSystemMysql.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suvha.libraryManagmentSystemMysql.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	public Optional<User> findById(long id);
}
