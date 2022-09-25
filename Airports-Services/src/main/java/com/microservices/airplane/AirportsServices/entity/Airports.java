package com.microservices.airplane.AirportsServices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Airports {

	
	@Id
	private String airport_id;
	
	@Transient
	private static int cpt=0;
	
	private String iata;
	
	private String icao;
	
	
	private String idAirportGeo;
	
	@Column(unique = true)
	private String airportname;
	

	public Airports() {
		super();
	}



	public Airports(String airport_id, String iata, String icao, String idAirportGeo, String airportname) {
		super();
		this.airport_id = airport_id;
		this.iata = iata;
		this.icao = icao;
		this.idAirportGeo = idAirportGeo;
		this.airportname = airportname;
	}


	public String getAirport_id() {
		return airport_id;
	}



	public void setAirport_id(String airport_id) {
		this.airport_id = airport_id;
	}



	public static int getCpt() {
		return cpt;
	}



	public static void setCpt(int cpt) {
		Airports.cpt = cpt;
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



	public String getIdAirportGeo() {
		return idAirportGeo;
	}



	public void setIdAirportGeo(String idAirportGeo) {
		this.idAirportGeo = idAirportGeo;
	}



	public String getAirport_name() {
		return airportname;
	}



	public void setAirport_name(String airport_name) {
		this.airportname = airport_name;
	}



	public void generateId() {
        this.airport_id = "airport_" + ++cpt;
    }
	
}
