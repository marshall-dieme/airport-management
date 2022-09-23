package com.saraya.passengerDetails.bean;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "passengerDetails")
public class PassengerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int passengerDetailsId;

    private LocalDate bithDate;

    private String sex;

    private String street;

    private String city;

    private String zip;

    private  String country;

    @Column(unique = true)
    private String email;

    private int telephone;

    public PassengerDetails() {
    }

    public PassengerDetails(int passengerDetailsId, LocalDate bithDate, String sex, String street, String city, String zip, String country, String email, int telephone) {
        this.passengerDetailsId = passengerDetailsId;
        this.bithDate = bithDate;
        this.sex = sex;
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.country = country;
        this.email = email;
        this.telephone = telephone;
    }

    public int getPassengerDetailsId() {
        return passengerDetailsId;
    }

    public void setPassengerDetailsId(int passengerDetailsId) {
        this.passengerDetailsId = passengerDetailsId;
    }

    public LocalDate getBithDate() {
        return bithDate;
    }

    public void setBithDate(LocalDate bithDate) {
        this.bithDate = bithDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
}
