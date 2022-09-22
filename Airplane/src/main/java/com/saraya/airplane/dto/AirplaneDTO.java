package com.saraya.airplane.dto;

public class AirplaneDTO {
	private Long airplane_id;
	private String capacity;
	public AirplaneDTO() {
		super();
	}
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
}
