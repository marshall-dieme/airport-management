package com.saraya.springBootJPA.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="players")
public class Players {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ; 
	@Column(name="player_name" , length=100)
	private String name ;
	@Column(length=50 , unique = true)
	private String username ; 
	private int age ; 
	
}
 