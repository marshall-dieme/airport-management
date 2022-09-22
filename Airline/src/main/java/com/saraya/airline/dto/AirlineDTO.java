package com.saraya.airline.dto;

public class AirlineDTO {
	private Long airline_id;
	private String airline_name;
	private String iata;
	public AirlineDTO() {
		super();
	}
	public Long getAirline_id() {
		return airline_id;
	}
	public void setAirline_id(Long airline_id) {
		this.airline_id = airline_id;
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
