package com.saraya.Airport_Geo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Airport_GeoModel {

	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int airport_geo_id;
	private String country;
	private String city;
	
	
	
	//constructor
	
public Airport_GeoModel() {
		super();
	}

public Airport_GeoModel(int airport_geo_id, String country, String city) {
		super();
		this.airport_geo_id = airport_geo_id;
		this.country = country;
		this.city = city;
	}

//getters and setters
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
	

	
	
	
	
}
