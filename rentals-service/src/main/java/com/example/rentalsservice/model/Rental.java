package com.example.rentalsservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentalId;

    private String name;

    private String email;

    private String contact;

    private String licenceNo;

    @Column(columnDefinition = "date")
    private LocalDate pickupDate;


    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime pickupTime;

    @Column(columnDefinition = "date")
    private LocalDate returnDate;


    @Column(columnDefinition = "timestamp")
    private LocalDateTime returnTime;

    private String carNo;

    private Double amount;

    private Long passengerId;


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

    public LocalDateTime getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(LocalDateTime pickupTime) {
        this.pickupTime = pickupTime;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LocalDateTime getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(LocalDateTime returnTime) {
        this.returnTime = returnTime;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getRentalId() {
        return rentalId;
    }

    public void setRentalId(Long rentalId) {
        this.rentalId = rentalId;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }
}
