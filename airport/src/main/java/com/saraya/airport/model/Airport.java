package com.saraya.airport.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Airport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long airportId;
	
	private String iata;
	
	private String icao;
	
	private String airportName;
	
	private Long airportGeoId;
	
	public Airport() {

	}

	public Airport(Long airportId, String iata, String icao, String airportName) {
		super();
		this.airportId = airportId;
		this.iata = iata;
		this.icao = icao;
		this.airportName = airportName;
	}

	public Long getAirportId() {
		return airportId;
	}

	public void setAirportId(Long airportId) {
		this.airportId = airportId;
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

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public Long getAirportGeoId() {
		return airportGeoId;
	}

	public void setAirportGeoId(Long airportGeoId) {
		this.airportGeoId = airportGeoId;
	}

	
}
