package com.saraya.passagerdetailsservice.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class PassagerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int passagerDetailsId;

    private LocalDate birthdate;

    private String sex;

    private String street;

    private String city;

    private String country;
    @Column(unique = true)
    private String email;

    private String telephone;

    private int passagerId;



    public int getPassagerId() {
        return passagerId;
    }

    public void setPassagerId(int passagerId) {
        this.passagerId = passagerId;
    }

    public PassagerDetails() {
    }

    public int getPassagerDetailsId() {
        return passagerDetailsId;
    }

    public void setPassagerDetailsId(int passagerDetailsId) {
        this.passagerDetailsId = passagerDetailsId;
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

    public PassagerDetails(int passagerDetailsId, LocalDate birthdate, String sex, String street, String city, String country, String email, String telephone) {
        this.passagerDetailsId = passagerDetailsId;
        this.birthdate = birthdate;
        this.sex = sex;
        this.street = street;
        this.city = city;
        this.country = country;
        this.email = email;
        this.telephone = telephone;
    }
}
