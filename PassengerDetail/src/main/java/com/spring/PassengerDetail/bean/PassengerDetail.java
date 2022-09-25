package com.spring.PassengerDetail.bean;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="passengerdetail")
public class PassengerDetail {
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int passengerdetailId;
	
private LocalDate birthday;
private String sex;
private String street;
private String city;
private String zip;
private String country;
private String email;
private int telephone;

public PassengerDetail() {
	
}


public PassengerDetail(int passengerdetailId, LocalDate birthday, String sex, String street, String city, String zip,
		String country, String email, int telephone) {
	
	this.passengerdetailId = passengerdetailId;
	this.birthday = birthday;
	this.sex = sex;
	this.street = street;
	this.city = city;
	this.zip = zip;
	this.country = country;
	this.email = email;
	this.telephone = telephone;
}


public int getPassengerdetailId() {
	return passengerdetailId;
}

public void setPassengerdetailId(int passengerdetailId) {
	this.passengerdetailId = passengerdetailId;
}

public LocalDate getBirthday() {
	return birthday;
}

public void setBirthday(LocalDate birthday) {
	this.birthday = birthday;
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



}
