package com.vlm.airplanetype.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "airplanes")
public class Airplane {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long airplane_type_id;
	
	@Column(name = "airplane_type_identifier")
	private String airplane_type_identifier;
	
	@Column(name = "description")
	private String description;

	public Airplane() {
	
    }
	
	public Airplane(String airplane_type_identifier, String description) {
		super();
		this.airplane_type_identifier = airplane_type_identifier;
		this.description = description;
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
