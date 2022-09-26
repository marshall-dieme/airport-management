package com.vlm.booking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bookings")
public class Booking {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long booking_id;
	
	@Column(name = "seat")
	private String seat;
	
	@Column(name = "price")
	private String price;
	
	public Booking() {
		
	}
	
	public Booking(String seat, String price) {
		super();
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

}
