package com.microservices.airline.Passager_Details.entity;

import java.time.LocalDate;

import javax.persistence.Column;

public class PassagerDetailsDto {

	private String id;
	
	private String birthdate;
	
	private String sex;
	
	private String street;
	
	private String city;
	
	private String zip;
	
	private String country;
	
	private String email;
	
	private int telephone;
	
	private String passportno;

	public PassagerDetailsDto() {
		super();
	}

	

	public PassagerDetailsDto(String id, String birthdate, String sex, String street, String city, String zip,
			String country, String email, int telephone, String passportno) {
		super();
		this.id = id;
		this.birthdate = birthdate;
		this.sex = sex;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.country = country;
		this.email = email;
		this.telephone = telephone;
		this.passportno = passportno;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getBirthdate() {
		return birthdate;
	}



	public void setBirthdate(String birthdate) {
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



	public int getTelephone() {
		return telephone;
	}



	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}



	public String getPassportno() {
		return passportno;
	}



	public void setPassportno(String passportno) {
		this.passportno = passportno;
	}



	
	
	
	
	
	
	
	
	
	
	
}
