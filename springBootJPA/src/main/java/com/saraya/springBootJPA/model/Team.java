package com.saraya.springBootJPA.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="teams")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private String name ; 
	
	
	@OneToOne
	private Players players;
	 
}
