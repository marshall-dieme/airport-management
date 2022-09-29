package com.airportmanager.Dto;

public class AirportToServices {
	private Long airport_id;
	private String iata;
	private String icao;
	private String airport_name;
	private Long service_id;
	private String service_name;
	
	//getters and setters
	
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
	public Long getService_id() {
		return service_id;
	}
	public void setService_id(Long service_id) {
		this.service_id = service_id;
	}
	public String getService_name() {
		return service_name;
	}
	public void setService_name(String service_name) {
		this.service_name = service_name;
	}
	
	

}
