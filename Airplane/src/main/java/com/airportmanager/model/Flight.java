package com.airportmanager.model;

import java.time.LocalDate;

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
@Table(name="flight")


public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long flight_id;
	
	@Column(name="flightno")
private String flight_no;

	@Column(name="departure")
private String departure;
	@Column(name="date")
private LocalDate date;
	@Column(name="from")
private String from;
	@Column(name="to")	
private String to;
	
	 @ManyToOne(fetch= FetchType.LAZY,cascade=CascadeType.ALL)
	  
	  @JoinColumn(name="airplane_id") private Airplane airplane;


public Flight() {
	
}

public Flight(Long flight_id, String flight_no, String departure, LocalDate date, String from, String to) {
	super();
	this.flight_id = flight_id;
	this.flight_no = flight_no;
	this.departure = departure;
	this.date = date;
	this.from = from;
	this.to = to;
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

@Override
public String toString() {
	return "Flight {flight_id=" + flight_id + ", flight_no=" + flight_no + ", departure=" + departure + ", date=" + date
			+ ", from=" + from + ", to=" + to + "}";
}




}
