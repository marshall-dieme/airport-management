package com.saraya.airportgeo.dto;

public class AirportGeoDTO {
	private Long airport_geo_id;
	 private String country;
	 private String city;
	 
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
