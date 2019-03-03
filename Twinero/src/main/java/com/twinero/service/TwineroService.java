package com.twinero.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twinero.jpa.Statment;
import com.twinero.jpa.UserDAO;
import com.twinero.repository.StatmentRepository;
import com.twinero.repository.UserRepository;

@Service
public class TwineroService implements ITwinero {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	StatmentRepository statmentRepository;
	
	@Override
	@Transactional
	public void deposit(String username, double amount) {
		Statment statment = new Statment(new Date(), amount);
		UserDAO user = userRepository.findById(username).orElse(null);
		if (user==null) {
			throw new RuntimeException("No such user");
		}
		user.balance = +amount;
		statmentRepository.save(statment);
		
	}

	@Override
	@Transactional
	public void withdraw(String username, double amount) {
		Statment statment = new Statment(new Date(), amount);
		UserDAO user = userRepository.findById(username).orElse(null);
		if (user==null) {
			throw new RuntimeException("No such user");
		}
		user.balance = -amount;
		statmentRepository.save(statment);
		
	}

	@Override
	@Transactional
	public double getBalance(String username) {
		UserDAO user = userRepository.findById(username).orElse(null);
		if (user==null) {
			throw new RuntimeException("No such user");
		}
		return user.balance;
		
	}

	@Override
	@Transactional
	public void printStatment(String username) {
		UserDAO user = userRepository.findById(username).orElse(null);
		if (user==null) {
			throw new RuntimeException("No such user");
		}
		user.statment.forEach(System.out::println);
		
	}

}
