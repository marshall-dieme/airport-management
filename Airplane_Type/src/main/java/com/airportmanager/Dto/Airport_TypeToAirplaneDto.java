package com.airportmanager.Dto;

public class Airport_TypeToAirplaneDto {
	private Long airplane_Type_id;
	private Long airplane_Type_identifier;
	private String description;
    private Long airplane_id;
	private String capacity;
	public Long getAirplane_Type_id() {
		return airplane_Type_id;
	}
	public void setAirplane_Type_id(Long airplane_Type_id) {
		this.airplane_Type_id = airplane_Type_id;
	}
	public Long getAirplane_Type_identifier() {
		return airplane_Type_identifier;
	}
	public void setAirplane_Type_identifier(Long airplane_Type_identifier) {
		this.airplane_Type_identifier = airplane_Type_identifier;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
