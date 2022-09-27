package com.saraya.microservices.airportmanagement.model;



public class Airport_Geo_DTO {

    private Long airport_geo_id; 
	
	private String country;
	
	private String city;
	
	private  String airp;

	public Airport_Geo_DTO() {
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

	public String getAirp() {
		return airp;
	}

	public void setAirp(String airp) {
		this.airp = airp;
	}

	public Airport_Geo_DTO(Long airport_geo_id, String country, String city, String airp) {
		super();
		this.airport_geo_id = airport_geo_id;
		this.country = country;
		this.city = city;
		this.airp = airp;
	}
	
	


	
	
	
}
