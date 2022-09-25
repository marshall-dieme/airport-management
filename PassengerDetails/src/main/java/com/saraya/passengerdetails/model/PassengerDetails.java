package com.saraya.passengerdetails.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PassengerDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long passenger_details_id;
	private LocalDate birthdate;
	private String sex;
	private String street;
	private String city;
	private String zip;
	private String country;
	private String email;
	private String telephone;
	public PassengerDetails() {
		super();
	}
	public Long getPassenger_details_id() {
		return passenger_details_id;
	}
	public void setPassenger_details_id(Long passenger_details_id) {
		this.passenger_details_id = passenger_details_id;
	}
	public LocalDate getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
	
}



 