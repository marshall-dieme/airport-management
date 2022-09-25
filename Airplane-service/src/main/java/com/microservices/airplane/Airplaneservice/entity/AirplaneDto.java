package com.microservices.airplane.Airplaneservice.entity;

public class AirplaneDto {

	
	private String id;
	
	private String capacity;
	
	private String airlinename;

	public AirplaneDto() {
		super();
	}

	public AirplaneDto(String id, String capacity, String airlinename) {
		super();
		this.id = id;
		this.capacity = capacity;
		this.airlinename = airlinename;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getAirlinename() {
		return airlinename;
	}

	public void setAirlinename(String airlinename) {
		this.airlinename = airlinename;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
