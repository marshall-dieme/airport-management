package com.saraya.bookingservice.bean;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int seat;

    private int price;

    @ElementCollection
    private List<Integer> flightId;

    @ElementCollection
    private List<Integer> passengerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Integer> getFlightId() {
        return flightId;
    }

    public void setFlightId(List<Integer> flightId) {
        this.flightId = flightId;
    }

    public List<Integer> getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(List<Integer> passengerId) {
        this.passengerId = passengerId;
    }
}
