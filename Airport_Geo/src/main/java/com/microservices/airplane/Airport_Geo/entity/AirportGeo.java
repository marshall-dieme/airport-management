package com.microservices.airplane.Airport_Geo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class AirportGeo {
	
	@Id
	private String id;
	
	
	@Transient
	private static int cpt =0;
	
	@Column(unique = true)
	private String country;
	
	private String city;
	
	
	

	public AirportGeo() {
		super();
	}

	public AirportGeo(String id, String country, String city) {
		super();
		this.id = id;
		this.country = country;
		this.city = city;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
	
	
	 public void generateId() {
	        this.id = "Airport_Geo_" + ++cpt;
	    }
	

}
