package com.twinero.jpa;


import java.util.List;

import javax.persistence.*;


@Entity
public class UserDAO {
	
	@Id
	public String username;
	public UserDAO(String username, String password, double balance) {
		super();
		this.username = username;
		this.password = password;
		this.balance = balance;
		
	}
	
	public UserDAO() {
		
	}

	public String password;
	public double balance;	
	
	@OneToMany(mappedBy="user")
	public List<Statment> statment;

}
