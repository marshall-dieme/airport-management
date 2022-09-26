package model;

import javax.persistence.Entity;

@Entity
public class Services {
	private long services_id;
	private String services_name;
	
	
	public Services() {
	
	}


	public Services(long services_id, String services_name) {
		super();
		this.services_id = services_id;
		this.services_name = services_name;
	}


	public long getServices_id() {
		return services_id;
	}


	public void setServices_id(long services_id) {
		this.services_id = services_id;
	}


	public String getServices_name() {
		return services_name;
	}


	public void setServices_name(String services_name) {
		this.services_name = services_name;
	}
	

}
