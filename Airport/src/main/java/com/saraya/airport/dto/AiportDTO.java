package com.saraya.airport.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AiportDTO {
	private Long airport_id;
	
	private String iata;
	
	private String icao;
	
	private String airport_name;
	
	private String country;
	
	 private String city;
	 
	 private Long airport_geo_id;

	public Long getAirport_id() {
		return airport_id;
	}

	public void setAirport_id(Long airport_id) {
		this.airport_id = airport_id;
	}

	public String getIata() {
		return iata;
	}

	public void setIata(String iata) {
		this.iata = iata;
	}

	public String getIcao() {
		return icao;
	}

	public void setIcao(String icao) {
		this.icao = icao;
	}

	public String getAirport_name() {
		return airport_name;
	}

	public void setAirport_name(String airport_name) {
		this.airport_name = airport_name;
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

	public Long getAirport_geo_id() {
		return airport_geo_id;
	}

	public void setAirport_geo_id(Long airport_geo_id) {
		this.airport_geo_id = airport_geo_id;
	}
	 
	
}
