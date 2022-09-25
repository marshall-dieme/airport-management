package com.saraya.passengerservice.bean;

import javax.persistence.*;

@Entity
@Table(name = "passengers")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String passportNo;

    private String firstname;

    private String lastname;

    private int bookingId;

    private int parckingId;

    private int rentalsId;

    private int passengerDetailsId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getParckingId() {
        return parckingId;
    }

    public void setParckingId(int parckingId) {
        this.parckingId = parckingId;
    }

    public int getRentalsId() {
        return rentalsId;
    }

    public void setRentalsId(int rentalsId) {
        this.rentalsId = rentalsId;
    }

    public int getPassengerDetailsId() {
        return passengerDetailsId;
    }

    public void setPassengerDetailsId(int passengerDetailsId) {
        this.passengerDetailsId = passengerDetailsId;
    }
}
