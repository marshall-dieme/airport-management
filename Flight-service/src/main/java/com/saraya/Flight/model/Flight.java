package com.saraya.Flight.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flightId;
	private String flightNo ;
	private LocalDate departureDate;
	private LocalDate arrivalDate;
	private String fromm;
	private String too;
	
	
	public Flight() {
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public LocalDate getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}
	public LocalDate getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public String getFromm() {
		return fromm;
	}
	public void setFromm(String fromm) {
		this.fromm = fromm;
	}
	public String getToo() {
		return too;
	}
	public void setToo(String too) {
		this.too = too;
	}
	
	

}
