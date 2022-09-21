package com.saraya.Services.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Services_airportDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int services_id;
	private String services_name;
	private int airport_id;
	private int employee_id;

		
	public int getServices_id() {
		return services_id;
	}
	public void setServices_id(int services_id) {
		this.services_id = services_id;
	}
	public String getServices_name() {
		return services_name;
	}
	public void setServices_name(String services_name) {
		this.services_name = services_name;
	}	
	public int getAirport_id() {
		return airport_id;
	}
	public void setAirport_id(int airport_id) {
		this.airport_id = airport_id;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public Services_airportDto() {
	}
	
	
	
	
	
}
