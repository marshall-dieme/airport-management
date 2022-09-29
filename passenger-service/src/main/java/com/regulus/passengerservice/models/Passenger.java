package com.regulus.passengerservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int passenger_id;

    private String passport_no;

    private String firstName;

    private String lastName;

    private  int booking_id;

    private  int parking_id;

    private  int rental_id;

    public Passenger() {
    }

    public Passenger(int passenger_id, String passport_no, String firstName, String lastName, int booking_id, int parking_id, int rental_id) {
        this.passenger_id = passenger_id;
        this.passport_no = passport_no;
        this.firstName = firstName;
        this.lastName = lastName;
        this.booking_id = booking_id;
        this.parking_id = parking_id;
        this.rental_id = rental_id;
    }

    public int getPassenger_id() {
        return passenger_id;
    }

    public void setPassenger_id(int passenger_id) {
        this.passenger_id = passenger_id;
    }

    public String getPassport_no() {
        return passport_no;
    }

    public void setPassport_no(String passport_no) {
        this.passport_no = passport_no;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public int getParking_id() {
        return parking_id;
    }

    public void setParking_id(int parking_id) {
        this.parking_id = parking_id;
    }

    public int getRental_id() {
        return rental_id;
    }

    public void setRental_id(int rental_id) {
        this.rental_id = rental_id;
    }
}
