package com.airportmanager.dto;

public class ServicesToAirportDto {
	private Long services_id;
	private String services_name;
	private Long airport_id;
	private String iata;
	private String icao;
	private String airport_name;
	
	public Long getServices_id() {
		return services_id;
	}
	public void setServices_id(Long services_id) {
		this.services_id = services_id;
	}
	public String getServices_name() {
		return services_name;
	}
	public void setServices_name(String services_name) {
		this.services_name = services_name;
	}
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
	
	
	

}
