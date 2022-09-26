package com.example.airlineservice.model;

public class AirlineDTO {

	private String airlineName;
	
	private String iata;

	public AirlineDTO() {
		super();
	}

	public AirlineDTO(String airlineName, String iata) {
		super();
		this.airlineName = airlineName;
		this.iata = iata;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getIata() {
		return iata;
	}

	public void setIata(String iata) {
		this.iata = iata;
	}
	
	
}
