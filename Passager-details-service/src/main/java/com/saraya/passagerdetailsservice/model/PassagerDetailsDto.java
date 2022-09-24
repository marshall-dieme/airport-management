package com.saraya.passagerdetailsservice.model;


public class PassagerDetailsDto {


	private int passengerDetailsId;
	private String birthdate;
	private String sex;
	private String street; 
	private String city;
	private String zip;
	private String country;
	private String email;
	private String telephone;
	private String passportNo;
	private int passengerId;


	
	
	public PassagerDetailsDto() {
	}


	public int getPassengerDetailsId() {
		return passengerDetailsId;
	}


	public void setPassengerDetailsId(int passengerDetailsId) {
		this.passengerDetailsId = passengerDetailsId;
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


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}



	public String getPassportNo() {
		return passportNo;
	}



	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}



	public int getPassengerId() {
		return passengerId;
	}



	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}	

	
	
}
