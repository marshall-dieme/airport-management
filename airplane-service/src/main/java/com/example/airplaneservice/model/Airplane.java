package com.example.airplaneservice.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Airplane {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "airplane_id")
	private Long airplaneId;
	
	private int capacity;
	
	@Column(name ="airline_id")
	private Long airlineId;

	public Airplane() {
		super();
	}

	public Airplane(Long airplaneId, int capacity, Long airlineId) {
		super();
		this.airplaneId = airplaneId;
		this.capacity = capacity;
		this.airlineId = airlineId;
	}

	public Long getAirplaneId() {
		return airplaneId;
	}

	public void setAirplaneId(Long airplaneId) {
		this.airplaneId = airplaneId;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Long getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(Long airlineId) {
		this.airlineId = airlineId;
	}
	
}
