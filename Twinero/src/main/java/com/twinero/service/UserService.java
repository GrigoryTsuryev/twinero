package com.twinero.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twinero.entities.UserDTO;
import com.twinero.jpa.UserDAO;
import com.twinero.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	
	public UserDAO addUser(UserDTO user) {
		if (user==null||user.username.isEmpty()) {
			throw new IllegalArgumentException("User name cant be empty");
		}
		String username = user.getUsername();
		String password = user.getPassword();
		double balance =user.getBalance();
		UserDAO userDao = new UserDAO(username, password, balance);
	
		return userRepository.save(userDao);
	}
}
