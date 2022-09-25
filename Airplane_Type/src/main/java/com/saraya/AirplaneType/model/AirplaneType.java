package com.saraya.AirplaneType.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AirplaneType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long airplane_type_id;
	private String airplane_type_identifier;
	private String description;
	public AirplaneType() {
		super();
	}
	public Long getAirplane_type_id() {
		return airplane_type_id;
	}
	public void setAirplane_type_id(Long airplane_type_id) {
		this.airplane_type_id = airplane_type_id;
	}
	public String getAirplane_type_identifier() {
		return airplane_type_identifier;
	}
	public void setAirplane_type_identifier(String airplane_type_identifier) {
		this.airplane_type_identifier = airplane_type_identifier;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}




