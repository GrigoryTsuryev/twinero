package com.twinero.jpa;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Statment {
	
	@Id
	@GeneratedValue
	int transactionId;

	public Date date;
	public Statment(Date date, double amountDelta) {
		super();
		this.date = date;
		this.amountDelta = amountDelta;
	}

	public double amountDelta;	
		
	@ManyToOne
	UserDAO user;
}
