package com.airportmanager.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="airline")
public class Airline {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long airline_id;
	@Column(name="name")
    private String airline_name;
	@Column(name="iata")
    private String iata;
	
	//relationship Airline to Airplane
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="airplane_id")private Airplane airplane;
	
	
	//constructors
public Airline() {
		
	}
	

	public Airline(Long airline_id, String airline_name, String iata) {
		super();
		this.airline_id = airline_id;
		this.airline_name = airline_name;
		this.iata = iata;
	}
    //getters and setters
    
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
	
	@Override
	public String toString() {
		return "Airline {airline_id=" + airline_id + 
				", airline_name=" + airline_name + ","
				+ " iata=" + iata + "}";
	}
    

}
