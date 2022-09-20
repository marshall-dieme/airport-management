package com.microservices.airplane.Airport.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;





@Entity
@Table(name="airport")
public class Airport {

	@Id
	private String airport_id;
	
	@Transient
	private static int cpt=0;
	
	private String iata;
	
	private String icao;
	
	
	@Column(unique = true)
	private String airport_name;
	
	
	private String idaiportGeo;
	

	
	public Airport() {
		super();
	}


	public Airport(String airport_id, String iata, String icao, String airport_name, String idaiportGeo) {
		super();
		this.airport_id = airport_id;
		this.iata = iata;
		this.icao = icao;
		this.airport_name = airport_name;
		this.idaiportGeo = idaiportGeo;
	}






	public String getAirport_id() {
		return airport_id;
	}



	public void setAirport_id(String airport_id) {
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
	
	
	
	 public void generateId() {
	        this.airport_id = "airport_" + ++cpt;
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
