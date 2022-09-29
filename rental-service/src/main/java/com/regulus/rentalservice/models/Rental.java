package com.regulus.rentalservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rental_id;

    private String name;

    private String email;

    private String contact;

    private String licence_no;

    private LocalDate pickup_date;

    private LocalTime pickup_time;

    private LocalDate return_date;

    private LocalTime return_time;

    private String car_no;

    private String amount;

    public Rental() {
    }

    public Rental(int rental_id, String name, String email, String contact, String licence_no, LocalDate pickup_date, LocalTime pickup_time, LocalDate return_date, LocalTime return_time, String car_no, String amount) {
        this.rental_id = rental_id;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.licence_no = licence_no;
        this.pickup_date = pickup_date;
        this.pickup_time = pickup_time;
        this.return_date = return_date;
        this.return_time = return_time;
        this.car_no = car_no;
        this.amount = amount;
    }

    public int getRental_id() {
        return rental_id;
    }

    public void setRental_id(int rental_id) {
        this.rental_id = rental_id;
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

    public String getLicence_no() {
        return licence_no;
    }

    public void setLicence_no(String licence_no) {
        this.licence_no = licence_no;
    }

    public LocalDate getPickup_date() {
        return pickup_date;
    }

    public void setPickup_date(LocalDate pickup_date) {
        this.pickup_date = pickup_date;
    }

    public LocalTime getPickup_time() {
        return pickup_time;
    }

    public void setPickup_time(LocalTime pickup_time) {
        this.pickup_time = pickup_time;
    }

    public LocalDate getReturn_date() {
        return return_date;
    }

    public void setReturn_date(LocalDate return_date) {
        this.return_date = return_date;
    }

    public LocalTime getReturn_time() {
        return return_time;
    }

    public void setReturn_time(LocalTime return_time) {
        this.return_time = return_time;
    }

    public String getCar_no() {
        return car_no;
    }

    public void setCar_no(String car_no) {
        this.car_no = car_no;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
