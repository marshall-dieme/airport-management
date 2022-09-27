package com.saraya.bookingservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long booking_id;
	
	private String seat;
	private int price;
	public Booking() {
		
	}
	public Booking(Long booking_id, String seat, int price) {
		this.booking_id = booking_id;
		this.seat = seat;
		this.price = price;
	}
	public Long getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(Long booking_id) {
		this.booking_id = booking_id;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
