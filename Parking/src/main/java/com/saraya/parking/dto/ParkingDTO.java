package com.saraya.parking.dto;



public class ParkingDTO {
	private Long parking_id;
	private String name;
	private String email;
	private String contact;
	private String  entry_date;
	private String entry_time; 
	private String exit_date;
	private String  exit_time;
	private String car_no;
	private int amount;
	public ParkingDTO() {
		super();
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
	public String getEntry_date() {
		return entry_date;
	}
	public void setEntry_date(String entry_date) {
		this.entry_date = entry_date;
	}
	public String getEntry_time() {
		return entry_time;
	}
	public void setEntry_time(String entry_time) {
		this.entry_time = entry_time;
	}
	public String getExit_date() {
		return exit_date;
	}
	public void setExit_date(String exit_date) {
		this.exit_date = exit_date;
	}
	public String getExit_time() {
		return exit_time;
	}
	public void setExit_time(String exit_time) {
		this.exit_time = exit_time;
	}
	public String getCar_no() {
		return car_no;
	}
	public void setCar_no(String car_no) {
		this.car_no = car_no;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
