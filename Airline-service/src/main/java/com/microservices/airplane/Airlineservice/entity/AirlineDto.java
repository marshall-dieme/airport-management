package com.microservices.airplane.Airlineservice.entity;

import javax.persistence.Transient;

public class AirlineDto {
	
	private String id;
	
	private String airlinename;
	
	
	private String iata;
	
	
	private String airportname;


	public AirlineDto() {
		super();
	}


	public AirlineDto(String id, String airlinename, String iata, String airportname) {
		super();
		this.id = id;
		this.airlinename = airlinename;
		this.iata = iata;
		this.airportname = airportname;
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


	public String getAirportname() {
		return airportname;
	}


	public void setAirportname(String airportname) {
		this.airportname = airportname;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
