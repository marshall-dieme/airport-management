package com.saraya.pasanger_details.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class PasangerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Double id;

    private LocalDate birthdate;
    private String sex;
    private  String street;
    private  String city;
    private  String zip;
    private  String country;
    private String email;
    private  int telephone;

    public PasangerDetails() {

    }

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
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

    public PasangerDetails(Double id, LocalDate birthdate, String sex, String street, String city, String zip, String country, String email, int telephone) {
        this.id = id;
        this.birthdate = birthdate;
        this.sex = sex;
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.country = country;
        this.email = email;
        this.telephone = telephone;
    }
}
