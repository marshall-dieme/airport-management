package com.microservices.airplane.Services.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Services {

	@Id
	private String service_id;
	
	
	private static int cpt=0;
	
	private String service_name;


	public Services() {
		super();
	}


	public Services(String service_id, String service_name) {
		super();
		this.service_id = service_id;
		this.service_name = service_name;
	}


	public String getService_id() {
		return service_id;
	}


	public void setService_id(String service_id) {
		this.service_id = service_id;
	}


	public String getService_name() {
		return service_name;
	}


	public void setService_name(String service_name) {
		this.service_name = service_name;
	}
	
	
	 public void generateId() {
	        this.service_id = "service_" + ++cpt;
	    }
	
	
	
	
	
}
