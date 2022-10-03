package com.saraya.microservicebookings.models;

import javax.persistence.*;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id", nullable = false)
    private Long booking_id;

    private String seat;
    private double price;

    public Booking() {
    }

    public Booking(Long booking_id, String seat, double price) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
