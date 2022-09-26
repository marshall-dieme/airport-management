package com.vlm.timetable.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tables")
public class Time {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long time_table_id;
	
	@Column(name = "flightFrom")
	private String flight_from;
	
	@Column(name = "flightTo")
	private String flight_to;
	
	@Column(name = "airline")
	private String airline;
	
	@Column(name = "flightTypee")
	private String flight_type;
	
	public Time() {
		
	}
	
	public Time(String flight_from, String flight_to, String airline, String flight_type) {
		super();
		this.flight_from = flight_from;
		this.flight_to = flight_to;
		this.airline = airline;
		this.flight_type = flight_type;
	}

	public Long getTime_table_id() {
		return time_table_id;
	}

	public void setTime_table_id(Long time_table_id) {
		this.time_table_id = time_table_id;
	}

	public String getFlight_from() {
		return flight_from;
	}

	public void setFlight_from(String flight_from) {
		this.flight_from = flight_from;
	}

	public String getFlight_to() {
		return flight_to;
	}

	public void setFlight_to(String flight_to) {
		this.flight_to = flight_to;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getFlight_type() {
		return flight_type;
	}

	public void setFlight_type(String flight_type) {
		this.flight_type = flight_type;
	}

}
