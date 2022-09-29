package com.airportmanager.dto;

public class AirplaneToAirlineDto {
	 private Long airplane_id;
	 private String capacity;
	 private String airline_name;
	 private String iata;
	 
		//getters and setters
	 
	public Long getAirplane_id() {
		return airplane_id;
	}
	public void setAirplane_id(Long airplane_id) {
		this.airplane_id = airplane_id;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public String getAirline_name() {
		return airline_name;
	}
	public void setAirline_name(String airline_name) {
		this.airline_name = airline_name;
	}
	public String getIata() {
		return iata;
	}
	public void setIata(String iata) {
		this.iata = iata;
	}
	 

	 
	 
	 

}
