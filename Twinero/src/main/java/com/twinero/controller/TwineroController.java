package com.twinero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.twinero.entities.StatmentDTO;
import com.twinero.entities.UserDTO;
import com.twinero.jpa.UserDAO;
import com.twinero.service.TwineroService;
import com.twinero.service.UserService;

@RestController
public class TwineroController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	TwineroService twineroService;

	@PostMapping("/users")
	UserDAO addUser(@RequestBody UserDTO user	) {
		return userService.addUser(user);
	}
	
	@PostMapping("/users/deposit")
	void deposit(@RequestBody StatmentDTO statment) {
		twineroService.deposit(statment.username, statment.amount);
	}
	
	@PostMapping("/users/withdraw")
	void withdraw(@RequestBody StatmentDTO statment) {
		twineroService.withdraw(statment.username, statment.amount);
	}
	
	@GetMapping("/users/balance/{username}")
	void getBalance(@PathVariable String username ) {
		twineroService.getBalance(username);
	}
	
	@GetMapping("/users/{username}")
	void printStatment(@PathVariable String username ) {
		twineroService.printStatment(username);
	}
	
	
	
	
	

}
