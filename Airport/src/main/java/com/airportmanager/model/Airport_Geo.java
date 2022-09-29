package com.airportmanager.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Airport_Geo")
public class Airport_Geo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long airport_geo_id;
	@Column(name="contry")
	private String country;
	@Column(name="city")
	private String city;
	

	
	@OneToOne(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinColumn(name="airport_id")private Airport airport;
	//constructors
	
	public Airport_Geo() {
		
	}
	public Airport_Geo(Long airport_geo_id, String country, String city) {
		super();
		this.airport_geo_id = airport_geo_id;
		this.country = country;
		this.city = city;
	}
	
	
	//getters and setters
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
	@Override
	public String toString() {
		return "Airport_Geo {airport_geo_id=" + airport_geo_id + ", country=" + country + ", city=" + city + "}";
	}
	
	

}
