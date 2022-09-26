package com.saraya.services.model;

public class ServicesDTO {

	private Long serviceId;
	
	private String serviceName;
	
	private String airportName;

	public ServicesDTO() {
		super();
	}

	public ServicesDTO(Long serviceId, String serviceName, String airportName) {
		super();
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.airportName = airportName;
	}

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	
}
