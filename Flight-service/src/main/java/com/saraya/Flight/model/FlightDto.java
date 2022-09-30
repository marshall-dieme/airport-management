package com.saraya.Flight.model;

public class FlightDto {
	
	private int flightId;
	private String flightNo ;
	private String departureDate;
	private String  arrivalDate;
	private String fromm;
	private String  too;
	
	
	public FlightDto() {
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
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
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
	public void setTo(String too) {
		this.too = too;
	}
	
	

}
