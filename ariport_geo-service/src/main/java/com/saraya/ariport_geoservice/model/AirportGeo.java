package com.saraya.ariport_geoservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AirportGeo {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long airportGeoId;
	
	
	private String country;
	
	
	private String city;

	public AirportGeo() {
		
	}

	public AirportGeo(Long airportGeoId, String country, String city) {
		super();
		this.airportGeoId = airportGeoId;
		this.country = country;
		this.city = city;
	}

	public Long getAirportGeoId() {
		return airportGeoId;
	}

	public void setAirportGeoId(Long airportGeoId) {
		this.airportGeoId = airportGeoId;
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
