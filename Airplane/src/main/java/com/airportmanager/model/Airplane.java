package com.airportmanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="airplan")
public class Airplane {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long airplane_id;
	
	@Column(name="capacity")
	private String capacity;
	
	
	//relationships  airplane  and airline
	  
	
	
	
	//constructors
	public Airplane() {
		
	}
	public Airplane(Long airplane_id, String capacity) {
		super();
		this.airplane_id = airplane_id;
		this.capacity = capacity;
	}
	//getters and setters
	public Long getAirplane_id() {
		return airplane_id;
	}
	public void setAirplane_id(Long airplane_id) {
		this.airplane_id = airplane_id;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	
	//To String Method
	@Override
	public String toString() {
		return "Airplane {airplane_id=" + airplane_id + ","
				          + " capacity=" + capacity + "}";
	}
	
	

}
