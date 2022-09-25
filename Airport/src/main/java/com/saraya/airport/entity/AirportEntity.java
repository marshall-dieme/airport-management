package com.saraya.airport.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class AirportEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long airport_id;
	
	private String iata;
	
	private String icao;
	
	private String airport_name;
	
	private Long airport_geo_id;

	public AirportEntity() {
		super();
	}
	
	
	
	public AirportEntity(Long airport_id, String iata, String icao, String airport_name, Long airport_geo_id) {
		super();
		this.airport_id = airport_id;
		this.iata = iata;
		this.icao = icao;
		this.airport_name = airport_name;
		this.airport_geo_id = airport_geo_id;
	}



	public Long getAirport_geo_id() {
		return airport_geo_id;
	}

	public void setAirport_geo_id(Long airport_geo_id) {
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
	
	
	
}
