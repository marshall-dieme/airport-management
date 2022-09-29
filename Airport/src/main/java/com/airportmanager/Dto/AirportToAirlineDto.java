package com.airportmanager.Dto;

public class AirportToAirlineDto {
	private Long airport_id;
	private String iata;
	private String icao;
	private String airport_name;
	private Long airline_id;
	private String airline_name;
	
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
	
	

}
