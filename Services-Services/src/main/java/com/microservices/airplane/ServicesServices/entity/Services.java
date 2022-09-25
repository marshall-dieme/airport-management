package com.microservices.airplane.ServicesServices.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Services {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String serviceName;
	
	private String idAir;

	public Services() {
		super();
	}

	public Services(int id, String serviceName, String idAir) {
		super();
		this.id = id;
		this.serviceName = serviceName;
		this.idAir = idAir;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getIdAir() {
		return idAir;
	}

	public void setIdAir(String idAir) {
		this.idAir = idAir;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
