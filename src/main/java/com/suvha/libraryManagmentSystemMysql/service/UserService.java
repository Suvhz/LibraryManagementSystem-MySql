package com.suvha.libraryManagmentSystemMysql.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.suvha.libraryManagmentSystemMysql.Repository.UserRepository;
import com.suvha.libraryManagmentSystemMysql.exception.DataNotFoundException;
import com.suvha.libraryManagmentSystemMysql.model.User;
import com.suvha.libraryManagmentSystemMysql.serviceDAO.ServiceDAO;

@Service
public class UserService implements ServiceDAO<User>{
	
	private UserRepository userRepository;

	@Override
	public User create(User t) {
		return userRepository.save(t);
	}

	@Override
	public Map<String, String> delete(int id) {
		User user = getById(id);
		userRepository.delete(user);
		return Collections.singletonMap("Response", "Deleted successfully.");
	}

	@Override
	public void deleteAll() {
		userRepository.deleteAll();
		
	}

	@Override
	public User update(User t) {
		User user = getById(t.getId());
		user.setEmail(t.getEmail());
		user.setFirstName(t.getFirstName());
		user.setLastName(t.getLastName());
		user.setPassword(t.getPassword());
		return userRepository.save(user);
	}

	@Override
	public User getById(long id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		throw new DataNotFoundException("User with id "+id+" not found");
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

}
