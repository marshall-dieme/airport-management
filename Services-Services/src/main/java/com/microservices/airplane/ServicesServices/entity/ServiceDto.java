package com.microservices.airplane.ServicesServices.entity;

public class ServiceDto {

	private int id;
	
	private String serviceName;
	
//	private String idAir;
	
	private String airportname;

	public ServiceDto() {
		super();
	}

	public ServiceDto(int id, String serviceName, String airportname) {
		super();
		this.id = id;
		this.serviceName = serviceName;
		this.airportname = airportname;
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

//	public String getIdAir() {
//		return idAir;
//	}
//
//	public void setIdAir(String idAir) {
//		this.idAir = idAir;
//	}

	public String getAirportname() {
		return airportname;
	}

	public void setAirportname(String airportname) {
		this.airportname = airportname;
	}
	
	
	
	
	
	
	
	
	
}
