package com.airportmanager.model;

import java.util.ArrayList;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Table;



@Entity
@Table(name="services")
public class Services {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long services_id;
	@Column(name="services_name")
	private String services_name;
	
	
	//relation service to employee
 	//@ManyToMany(fetch=FetchType.LAZY,cascade= {CascadeType.PERSIST,CascadeType.MERGE},
 			//mappedBy="services")
 	//@JsonIgnore
 	//private Set<Employee> employee= new HashSet<>();
	
	@ManyToMany
	  @JoinTable(name = "sevicesemployee",
	             joinColumns = @JoinColumn(name = "service_id"),
	             inverseJoinColumns = @JoinColumn(name = "employee_id"))
	  private List<Employee> employee = new ArrayList<>();
	
	
	public Services() {
		
	}
	
	public Services(Long services_id, String services_name) {
		super();
		this.services_id = services_id;
		this.services_name = services_name;
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
