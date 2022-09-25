package com.saraya.appli.dto;

public class ServicesDTO {
	private Long services_id;
	private String services_name;
	public ServicesDTO(Long services_id, String services_name) {
		super();
		this.services_id = services_id;
		this.services_name = services_name;
	}
	public ServicesDTO() {
		// TODO Auto-generated constructor stub
	}
	public Long getServices_id() {
		return services_id;
	}
	public void setServices_id(Long services_id) {
		this.services_id = services_id;
	}
	public String getServices_name() {
		return services_name;
	}
	public void setServices_name(String services_name) {
		this.services_name = services_name;
	}
	
}
