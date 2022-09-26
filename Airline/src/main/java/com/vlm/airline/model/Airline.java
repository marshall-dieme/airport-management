package com.vlm.airline.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "airlines")
public class Airline {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long airline_id;
	
	@Column(name = "airlineName")
	private String airline_name;
	
	@Column(name = "iatae")
	private String iata;
	
	public Airline() {
		
	}
	
	public Airline(String airline_name, String iata) {
		super();
		this.airline_name = airline_name;
		this.iata = iata;
	}

	public Long getAirline_id() {
		return airline_id;
	}

	public void setAirline_id(Long airline_id) {
		this.airline_id = airline_id;
	}

	public String getAirline_name() {
		return airline_name;
	}

	public void setAirline_name(String airline_name) {
		this.airline_name = airline_name;
	}

	public String getIata() {
		return iata;
	}

	public void setIata(String iata) {
		this.iata = iata;
	}

		
}
