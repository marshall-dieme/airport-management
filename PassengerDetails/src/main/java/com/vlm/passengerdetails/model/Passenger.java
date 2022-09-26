package com.vlm.passengerdetails.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "passengers")
public class Passenger {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long passenger_details_id;
	
	@JsonFormat(pattern = "yyy-MM-dd" , shape = Shape.STRING)
	@Column(name = "birthDate")
	private Date birthdate;
	
	@Column(name = "sex")
	private String sex;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "zip")
	private String zip;
	
	@Column(name = "contry")
	private String country;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "telephone")
	private String telephone;
	
	public Passenger() {
		
	}

	public Passenger(Date birthdate, String sex, String street, String city, String zip, String country, String email,
			String telephone) {
		super();
		this.birthdate = birthdate;
		this.sex = sex;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.country = country;
		this.email = email;
		this.telephone = telephone;
	}

	public Long getPassenger_details_id() {
		return passenger_details_id;
	}

	public void setPassenger_details_id(Long passenger_details_id) {
		this.passenger_details_id = passenger_details_id;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
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
