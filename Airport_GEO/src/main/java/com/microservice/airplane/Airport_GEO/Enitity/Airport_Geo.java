package com.microservice.airplane.Airport_GEO.Enitity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "airport_geo")
public class Airport_Geo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long aiport_geo_id ;
	
	@Column(unique = true)
	private String country;
	
	private String city;

	public Airport_Geo() {
		super();
	}

	public Airport_Geo(Long aiport_geo_id, String country, String city) {
		super();
		this.aiport_geo_id = aiport_geo_id;
		this.country = country;
		this.city = city;
	}

	public Long getAiport_geo_id() {
		return aiport_geo_id;
	}

	public void setAiport_geo_id(Long aiport_geo_id) {
		this.aiport_geo_id = aiport_geo_id;
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
