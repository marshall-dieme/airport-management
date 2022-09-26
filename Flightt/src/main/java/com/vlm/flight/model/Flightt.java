package com.vlm.flight.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flightts")
public class Flightt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flight_id;
	
	@Column(name = "depertureDate")
	private LocalDateTime departure_date;
	
	@Column(name = "arrivalDate")
	private LocalDateTime arrival_date;
	
	@Column(name = "from")
	private String from;
	
	@Column(name = "to")
	private String to;
	
	public Flightt() {
		
	}
	
	public Flightt(LocalDateTime departure_date, LocalDateTime arrival_date, String from, String to) {
		super();
		this.departure_date = departure_date;
		this.arrival_date = arrival_date;
		this.from = from;
		this.to = to;
	}
	public int getFlight_id() {
		return flight_id;
	}
	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
	}
	public LocalDateTime getDeparture_date() {
		return departure_date;
	}
	public void setDeparture_date(LocalDateTime departure_date) {
		this.departure_date = departure_date;
	}
	public LocalDateTime getArrival_date() {
		return arrival_date;
	}
	public void setArrival_date(LocalDateTime arrival_date) {
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
