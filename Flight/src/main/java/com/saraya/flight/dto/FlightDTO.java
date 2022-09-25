package com.saraya.flight.dto;

import java.time.LocalDate;

public class FlightDTO {
	private Long flight_id;
	private String flight_no;
	private String departure_date; 
	private String arrival_date;
	private String from;
	private String to;
	public FlightDTO() {
		super();
	}
	public Long getFlight_id() {
		return flight_id;
	}
	public void setFlight_id(Long flight_id) {
		this.flight_id = flight_id;
	}
	public String getFlight_no() {
		return flight_no;
	}
	public void setFlight_no(String flight_no) {
		this.flight_no = flight_no;
	}
	public String getDeparture_date() {
		return departure_date;
	}
	public void setDeparture_date(String departure_date) {
		this.departure_date = departure_date;
	}
	public String getArrival_date() {
		return arrival_date;
	}
	public void setArrival_date(String arrival_date) {
		this.arrival_date = arrival_date;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	
	
}
