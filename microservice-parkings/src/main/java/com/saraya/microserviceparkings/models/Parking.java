package com.saraya.microserviceparkings.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parking_id", nullable = false)
    private Long parking_id;

    private String name;
    private String email;
    private String contact;
    private LocalDate entry_date;
    private LocalTime entry_time;
    private LocalDate exit_date;
    private LocalTime exit_time;
    private String car_no;
    private float amount;

    public Parking(Long parking_id, String name, String email, String contact, LocalDate entry_date, LocalTime entry_time, LocalDate exit_date, LocalTime exit_time, String car_no, float amount) {
        this.parking_id = parking_id;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.entry_date = entry_date;
        this.entry_time = entry_time;
        this.exit_date = exit_date;
        this.exit_time = exit_time;
        this.car_no = car_no;
        this.amount = amount;
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

    public LocalDate getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(LocalDate entry_date) {
        this.entry_date = entry_date;
    }

    public LocalTime getEntry_time() {
        return entry_time;
    }

    public void setEntry_time(LocalTime entry_time) {
        this.entry_time = entry_time;
    }

    public LocalDate getExit_date() {
        return exit_date;
    }

    public void setExit_date(LocalDate exit_date) {
        this.exit_date = exit_date;
    }

    public LocalTime getExit_time() {
        return exit_time;
    }

    public void setExit_time(LocalTime exit_time) {
        this.exit_time = exit_time;
    }

    public String getCar_no() {
        return car_no;
    }

    public void setCar_no(String car_no) {
        this.car_no = car_no;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
