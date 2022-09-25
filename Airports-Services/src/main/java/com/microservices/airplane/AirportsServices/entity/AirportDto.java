package com.microservices.airplane.AirportsServices.entity;

public class AirportDto {
	
	
	private String airport_id;
	
	private String iata;
	
	private String icao;
	
	private String airportname;
	
	private String country;
	
	private String city;

	public AirportDto() {
		super();
	}

	public AirportDto(String airport_id, String iata, String icao, String airportname, String country, String city) {
		super();
		this.airport_id = airport_id;
		this.iata = iata;
		this.icao = icao;
		this.airportname = airportname;
		this.country = country;
		this.city = city;
	}

	public String getAirport_id() {
		return airport_id;
	}

	public void setAirport_id(String airport_id) {
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
		return airportname;
	}

	public void setAirport_name(String airport_name) {
		this.airportname = airport_name;
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
