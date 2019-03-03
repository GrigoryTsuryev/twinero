package com.twinero.service;


public interface ITwinero {
	
	
	double getBalance(String username);
	void printStatment(String username);
	void deposit(String username, double amount);
	void withdraw(String username, double amount);
	
	
}
