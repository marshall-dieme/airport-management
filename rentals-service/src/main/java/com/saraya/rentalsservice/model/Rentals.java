package com.saraya.rentalsservice.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Rentals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rentalId;

    private String name;

    private String email;

    private String contact;

    @Column(unique = true)
    private String licenceNo;

    private LocalDate pickupDate;

    private LocalTime pickupTime;

    private LocalDate returnDate;

    private LocalTime returnTime;

    private String carNo;

    private int amount;

    public Rentals() {
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
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

    public String getLicenceNo() {
        return licenceNo;
    }

    public void setLicenceNo(String licenceNo) {
        this.licenceNo = licenceNo;
    }

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDate pickupDate) {
        this.pickupDate = pickupDate;
    }

    public LocalTime getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(LocalTime pickupTime) {
        this.pickupTime = pickupTime;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LocalTime getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(LocalTime returnTime) {
        this.returnTime = returnTime;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Rentals(int rentalId, String name, String email, String contact, String licenceNo, LocalDate pickupDate, LocalTime pickupTime, LocalDate returnDate, LocalTime returnTime, String carNo, int amount) {
        this.rentalId = rentalId;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.licenceNo = licenceNo;
        this.pickupDate = pickupDate;
        this.pickupTime = pickupTime;
        this.returnDate = returnDate;
        this.returnTime = returnTime;
        this.carNo = carNo;
        this.amount = amount;
    }
}
