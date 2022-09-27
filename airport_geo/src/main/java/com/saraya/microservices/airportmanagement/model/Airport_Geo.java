package com.saraya.microservices.airportmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity	
public class Airport_Geo {
 
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 
    private Long airport_geo_id; 
	
	private String country;
	
	@Column(name = "name")
	private String city;
	
	private  String  airport_id;
	
   public Airport_Geo() {
      }
   
	public Airport_Geo(Long airport_geo_id, String country, String city, String airport_id) {
		super();
		this.airport_geo_id = airport_geo_id;
		this.country = country;
		this.city = city;
		this.airport_id = airport_id;
	}
	public Long getAirport_geo_id() {
		return airport_geo_id;
	}
	public void setAirport_geo_id(Long airport_geo_id) {
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
	public String getAirport_id() {
		return airport_id;
	}
	public String setAirport_id(String airport_id) {
		return airport_id;
	}

	public Airport_Geo(Long airport_geo_id) {
		super();
		this.airport_geo_id = airport_geo_id;
	}

	
		


	
	
	
}
