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
@Table(name="service")
public class Services {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long service_id;
	@Column(name="service_name")
	private String service_name;
	
	
	//relationshipServices
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="airport_id")private Airport airport;
   
	
	
	//constructors
	public Services() {
		
	}
	
	public Services(Long service_id, String service_name) {
		super();
		this.service_id = service_id;
		this.service_name = service_name;
	}
	//getters and setters
	
	public Long getService_id() {
		return service_id;
	}

	public void setService_id(Long service_id) {
		this.service_id = service_id;
	}

	public String getService_name() {
		return service_name;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}
	//ToString

	@Override
	public String toString() {
		return "Services {service_id=" + service_id + ", service_name=" + service_name + "}";
	}
	

}
