package com.example.airplaneservice.model;

public class AirplaneDTO {

	private int capacity;
	
	private String airlineName;

	public AirplaneDTO() {
		super();
	}

	public AirplaneDTO(int capacity, String airlineName) {
		super();
		this.capacity = capacity;
		this.airlineName = airlineName;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	
	
}
