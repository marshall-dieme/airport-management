package com.saraya.passenger.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Passengar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long passenger_id;
	private String passport_no;
	private String firstname;
	private String lastname;
	public Passengar() {
		super();
	}
	public Long getPassenger_id() {
		return passenger_id;
	}
	public void setPassenger_id(Long passenger_id) {
		this.passenger_id = passenger_id;
	}
	public String getPassport_no() {
		return passport_no;
	}
	public void setPassport_no(String passport_no) {
		this.passport_no = passport_no;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
}
