package com.example.parkingservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parking_id", nullable = false)
    private Long parkingId;

    private String name;

    private String email;

    private String contact;


    @Column(columnDefinition = "date")
    private LocalDate entryDate;


    @Column(columnDefinition = "timestamp")
    private LocalDateTime entryTime;

    @Column(columnDefinition = "date")
    private LocalDate exitDate;


    @Column(columnDefinition = "timestamp")
    private LocalDateTime exitTime;

    private String carNo;

    private Double amount;

    private Long passengerId;

    public Long getParkingId() {
        return parkingId;
    }

    public void setParkingId(Long parkingId) {
        this.parkingId = parkingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalDate getExitDate() {
        return exitDate;
    }

    public void setExitDate(LocalDate exitDate) {
        this.exitDate = exitDate;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
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

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
