package com.vlm.rentals.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name = "rentalss")
public class Rentals {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rental_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "contact")
	private String contact;
	
	@Column(name = "licenceNo")
	private String licence_no;
	
	@CreationTimestamp
	@Column(name = "pickupDate", nullable = false, updatable = false)
	private LocalDateTime pickup_date;
	
	@CreationTimestamp
	@Column(name = "returnDate", nullable = false, updatable = false)
	private LocalDateTime return_date;
	
	@Column(name = "carNo")
	private String car_no;
	
	@Column(name = "Amount")
	private String amount;
	
	public Rentals() {
		
	}
	
	public Rentals(String name, String email, String contact, String licence_no, LocalDateTime pickup_date,
			LocalDateTime return_date, String car_no, String amount) {
		super();
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.licence_no = licence_no;
		this.pickup_date = pickup_date;
		this.return_date = return_date;
		this.car_no = car_no;
		this.amount = amount;
	}
	public Long getRental_id() {
		return rental_id;
	}
	public void setRental_id(Long rental_id) {
		this.rental_id = rental_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getLicence_no() {
		return licence_no;
	}
	public void setLicence_no(String licence_no) {
		this.licence_no = licence_no;
	}
	public LocalDateTime getPickup_date() {
		return pickup_date;
	}
	public void setPickup_date(LocalDateTime pickup_date) {
		this.pickup_date = pickup_date;
	}
	public LocalDateTime getReturn_date() {
		return return_date;
	}
	public void setReturn_date(LocalDateTime return_date) {
		this.return_date = return_date;
	}
	public String getCar_no() {
		return car_no;
	}
	public void setCar_no(String car_no) {
		this.car_no = car_no;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
}
