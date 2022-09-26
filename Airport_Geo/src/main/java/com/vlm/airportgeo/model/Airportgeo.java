package com.vlm.airportgeo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "airports")
public class Airportgeo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long airport_geo_id;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "city")
	private String city;
	
	public Airportgeo() {
		
	}
	
	public Airportgeo(String country, String city) {
		super();
		this.country = country;
		this.setCity(city);
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

}
