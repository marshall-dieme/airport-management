package com.saraya.microservices.airplane.model;

public class AirplaneDTO {
 
	
    private Long airplane_id;
	
	public String capacity;

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

	public AirplaneDTO(Long airplane_id, String capacity) {
		super();
		this.airplane_id = airplane_id;
		this.capacity = capacity;
	}
	

	
}
