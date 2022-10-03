package com.airportmanager.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="airplane_Type")
public class Airplane_Type {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long airplane_Type_id;
	@Column(name="airplane_Type_identifier")
	private Long airplane_Type_identifier;
	@Column(name="description")
	private String description;
	
	
	
	//relationships  airplane  and airplane_type
	
	  @ManyToOne(fetch= FetchType.LAZY,cascade=CascadeType.ALL)
	  @JoinColumn(name="airplane_id") private Airplane airplane;
	
	
public Airplane_Type() {
		
	}
	
	public Airplane_Type(Long airplane_Type_id, Long airplane_Type_identifier, String description) {
		super();
		this.airplane_Type_id = airplane_Type_id;
		this.airplane_Type_identifier = airplane_Type_identifier;
		this.description = description;
	}

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

	@Override
	public String toString() {
		return "Airplane_Type {airplane_Type_id=" + airplane_Type_id + ", airplane_Type_identifier="
				+ airplane_Type_identifier + ", description=" + description + "}";
	}
	
	
	
	
	
	
	
	

}
