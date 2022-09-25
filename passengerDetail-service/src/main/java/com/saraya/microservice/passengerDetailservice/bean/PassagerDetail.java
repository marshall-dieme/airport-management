package com.saraya.microservice.passengerDetailservice.bean;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class PassagerDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int passager_details_id;

    private String sex;
    private LocalDate birthdate;

    private String street;

    private String city;

    private String zip;
    private String country;

    private String email;

    private String telephone;

    public PassagerDetail() {
    }

    public int getPassager_details_id() {
        return passager_details_id;
    }

    public void setPassager_details_id(int passager_details_id) {
        this.passager_details_id = passager_details_id;
    }

    public PassagerDetail(String sex, LocalDate birthdate, String street, String city, String zip, String country, String email, String telephone) {
        this.sex = sex;
        this.birthdate = birthdate;
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.country = country;
        this.email = email;
        this.telephone = telephone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
