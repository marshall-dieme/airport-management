package com.example.airlineservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Airline {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "airline_id")
	private Long airlineId;
	
	@Column(name = "airline_name")
	private String airlineName;
	
	private String iata;
	
	private Long airportId;

	public Airline() {
		super();
	}

	public Airline(Long airlineId, String airlineName, String iata, Long airportId) {
		super();
		this.airlineId = airlineId;
		this.airlineName = airlineName;
		this.iata = iata;
		this.airportId = airportId;
	}

	public Long getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(Long airlineId) {
		this.airlineId = airlineId;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getIata() {
		return iata;
	}

	public void setIata(String iata) {
		this.iata = iata;
	}

	public Long getAirportId() {
		return airportId;
	}

	public void setAirportId(Long airportId) {
		this.airportId = airportId;
	}
	
	
}
