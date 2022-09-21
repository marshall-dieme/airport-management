package com.saraya.Airport.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Airport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int airport_id;
	private String iata;
	private String icao;
	private String airport_name;
	private int airport_geo_id;
	private int services_id;

	
	public Airport() {
	}
	public int getAirport_id() {
		return airport_id;
	}
	public void setAirport_id(int airport_id) {
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
	public int getAirport_geo_id() {
		return airport_geo_id;
	}
	public void setAirport_geo_id(int airport_geo_id) {
		this.airport_geo_id = airport_geo_id;
	}
	public int getServices_id() {
		return services_id;
	}
	public void setServices_id(int services_id) {
		this.services_id = services_id;
	}
	
	
}
