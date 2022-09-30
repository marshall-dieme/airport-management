package com.saraya.employee.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee_Services {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employees_services_id;
	private Long employee_id;
	private Long services_id;
	
	public Employee_Services() {
		super();
	}

	public Long getEmployees_services_id() {
		return employees_services_id;
	}

	public void setEmployees_services_id(Long employees_services_id) {
		this.employees_services_id = employees_services_id;
	}

	public Long getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Long employee_id) {
		this.employee_id = employee_id;
	}

	public Long getServices_id() {
		return services_id;
	}

	public void setServices_id(Long services_id) {
		this.services_id = services_id;
	}
	
	
}
