package com.microservices.airline.Passager_Details.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PassagerDetails {

	@Id
	private String id;
	
	private static int  cpt=0;
	
	private LocalDate birthdate;
	
	private String sex;
	
	private String street;
	
	private String city;
	
	private String zip;
	
	private String country;
	
	private String idpass;
	
	@Column(unique = true)
	private String email;
	
	@Column(unique = true)
	private int telephone;

	public PassagerDetails() {
		super();
	}

	
	public PassagerDetails(String id, LocalDate birthdate, String sex, String street, String city, String zip,
			String country, String idpass, String email, int telephone) {
		super();
		this.id = id;
		this.birthdate = birthdate;
		this.sex = sex;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.country = country;
		this.idpass = idpass;
		this.email = email;
		this.telephone = telephone;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public static int getCpt() {
		return cpt;
	}


	public static void setCpt(int cpt) {
		PassagerDetails.cpt = cpt;
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


	public String getIdpass() {
		return idpass;
	}


	public void setIdpass(String idpass) {
		this.idpass = idpass;
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


	public void generateId() {
		this.id = "passenger_details_" + ++cpt;
		
	}

	
}
