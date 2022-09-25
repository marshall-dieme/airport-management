package com.saraya.flight.bean;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long flight_id;
	private String flight_no;
	private LocalDate departure_date; 
	private LocalDate arrival_date;
	private String from;
	private String to;
	public Flight() {
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
	public LocalDate getDeparture_date() {
		return departure_date;
	}
	public void setDeparture_date(LocalDate departure_date) {
		this.departure_date = departure_date;
	}
	public LocalDate getArrival_date() {
		return arrival_date;
	}
	public void setArrival_date(LocalDate arrival_date) {
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
