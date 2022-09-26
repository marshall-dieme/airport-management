package com.vlm.services.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "servicess")
public class Services {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long services_id;
	
	@Column(name = "service_name")
	private String serviceName;
	
	public Services() {
		
	}
	
	public Services(String serviceName) {
		super();
		this.serviceName = serviceName;
	}

	public Long getServices_id() {
		return services_id;
	}

	public void setServices_id(Long services_id) {
		this.services_id = services_id;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}


}
