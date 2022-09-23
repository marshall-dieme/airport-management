package com.saraya.passagerdetailsservice.model;

import java.time.LocalDate;

public class PassagerDetailsDTO {

    private int passagerDetailsId;

    private String birthdate;

    private String sex;

    private String street;

    private String city;

    private String country;

    private String email;

    private String telephone;

    public int getPassagerDetailsId() {
        return passagerDetailsId;
    }

    public void setPassagerDetailsId(int passagerDetailsId) {
        this.passagerDetailsId = passagerDetailsId;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
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

    public PassagerDetailsDTO(int passagerDetailsId, String birthdate, String sex, String street, String city, String country, String email, String telephone) {
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
