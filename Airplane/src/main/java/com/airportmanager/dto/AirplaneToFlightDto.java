package com.airportmanager.dto;

import java.time.LocalDate;

public class AirplaneToFlightDto {
	private Long airplane_id;
	private String capacity;
	private String flight_no;
	private String departure;
	private LocalDate date;
	private String from;
	private String to;
	
	
	//getters and setters
	
	public Long getAirplane_id() {
		return airplane_id;
	}
	public void setAirplane_id(Long airplane_id) {
		this.airplane_id = airplane_id;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public String getFlight_no() {
		return flight_no;
	}
	public void setFlight_no(String flight_no) {
		this.flight_no = flight_no;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
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
