package com.saraya.airportgeo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Airport_Geo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int airport_geo_id;
	private String country;
	private String city;	
	private int airport_id;	
	
	public Airport_Geo() {
	}

	public int getAirport_geo_id() {
		return airport_geo_id;
	}

	public void setAirport_geo_id(int airport_geo_id) {
		this.airport_geo_id = airport_geo_id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAirport_id() {
		return airport_id;
	}

	public void setAirport_id(int airport_id) {
		this.airport_id = airport_id;
	}

	

	
	
}
