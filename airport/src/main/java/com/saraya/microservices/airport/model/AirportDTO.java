package com.saraya.microservices.airport.model;

public class AirportDTO {
 
	
	private Long airport_id;
	
	public String iata;
	
	public String icao;
	
	public String airport_name;
	
	private String airport_geo_id;
	
	
	public AirportDTO() {
		
	}

	public AirportDTO(Long airport_id, String iata, String icao, String airport_name, String airport_geo_id) {
		super();
		this.airport_id = airport_id;
		this.iata = iata;
		this.icao = icao;
		this.airport_name = airport_name;
		this.airport_geo_id = airport_geo_id;
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
	

	public String getAirport_geo_id() {
		return airport_geo_id;
	}

	public void setAirport_geo_id(String airport_geo_id) {
		this.airport_geo_id = airport_geo_id;
	}
	
	
	
}
