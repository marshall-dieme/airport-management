package com.saraya.Airline.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Airline {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int airline_id;
	private String airline_name;
	private String iata;
	private int airport_id;
	private int airplane_type_id;
	
	
	public Airline() {
	}
	public int getAirline_id() {
		return airline_id;
	}
	public void setAirline_id(int airline_id) {
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
	public int getAirport_id() {
		return airport_id;
	}
	public void setAirport_id(int airport_id) {
		this.airport_id = airport_id;
	}
	public int getAirplane_type_id() {
		return airplane_type_id;
	}
	public void setAirplane_type_id(int airplane_type_id) {
		this.airplane_type_id = airplane_type_id;
	}
	
	
}
