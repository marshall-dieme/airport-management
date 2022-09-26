package com.vlm.parking.model;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "parkings")
public class Parking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long parking_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "contact")
	private String contact;
	
	@CreationTimestamp
	@Column(name = "entryDate", nullable = false, updatable = false)
	private LocalDateTime localDate1 = LocalDateTime.now();
	
	@CreationTimestamp
	@Column(name = "exitDate", nullable = false, updatable = false)
	private LocalDateTime localDate = LocalDateTime.now();
	
	@Column(name = "carNo")
	private String car_no;
	
	@Column(name = "amount")
	private String amount;
	
	public Parking() {
		
	}
	
	public Parking(String name, String email, String contact, LocalDateTime entry_date, LocalDateTime exit_date, String car_no,
			String amount) {
		super();
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.localDate1 = entry_date;
		this.localDate = exit_date;
		this.car_no = car_no;
		this.amount = amount;
	}
	public Long getParking_id() {
		return parking_id;
	}
	public void setParking_id(Long parking_id) {
		this.parking_id = parking_id;
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
	public LocalDateTime getEntry_date() {
		return localDate1;
	}
	public void setEntry_date(LocalDateTime entry_date) {
		this.localDate1 = entry_date;
	}
	public LocalDateTime getExit_date() {
		return localDate1;
	}
	public void setExit_date(LocalDateTime exit_date) {
		this.localDate1 = exit_date;
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
