package com.microservices.airplane.Airlineservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Airline {

	@Id
	private String id;
	
	@Transient
	private static int cpt=0;
	
	@Column(unique = true)
	private String airlinename;
	
	
	private String iata;
	
	
	private String idAir;

	

	public Airline() {
		super();
	}


	public Airline(String id, String airlinename, String iata, String idAir) {
		super();
		this.id = id;
		this.airlinename = airlinename;
		this.iata = iata;
		this.idAir = idAir;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getAirlinename() {
		return airlinename;
	}


	public void setAirlinename(String airlinename) {
		this.airlinename = airlinename;
	}


	public String getIata() {
		return iata;
	}


	public void setIata(String iata) {
		this.iata = iata;
	}


	public String getIdAir() {
		return idAir;
	}


	public void setIdAir(String idAir) {
		this.idAir = idAir;
	}
	
	

	public void generateId() {
        this.id = "airline_" + ++cpt;
    }
	
	
	
	
	
	
	
	
	
}
