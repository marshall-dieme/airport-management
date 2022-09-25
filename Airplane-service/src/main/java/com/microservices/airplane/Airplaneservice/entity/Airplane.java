package com.microservices.airplane.Airplaneservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.type.TrueFalseType;

@Entity
public class Airplane {
	
	@Id
	private String id;

	@Transient
	private static int cpt=0;
	
	
	private String capacity;

	
	private String idairline;


	public Airplane() {
		super();
	}


	public Airplane(String id, String capacity, String idairline) {
		super();
		this.id = id;
		this.capacity = capacity;
		this.idairline = idairline;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getCapacity() {
		return capacity;
	}


	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}


	public String getIdAirline() {
		return idairline;
	}


	public void setIdAirline(String idAirline) {
		this.idairline = idAirline;
	}
	
	
	
	public void generateId() {
        this.id = "airplane_" + ++cpt;
    }
	
	
	
	
	
	
	
}
