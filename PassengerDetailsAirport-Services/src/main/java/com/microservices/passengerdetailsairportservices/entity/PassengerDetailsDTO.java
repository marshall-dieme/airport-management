package com.microservices.passengerdetailsairportservices.entity;


public class PassengerDetailsDTO {

    private Long passengerdetailsId;

    private String birthdate;

    private String sexe;

    private String street;

    private String city;

    private String zip;

    private String country;

    private String email;

    private String telephone;

    private String NumberPassport;

    public Long getPassengerdetailsId() {
        return passengerdetailsId;
    }

    public void setPassengerdetailsId(Long passengerdetailsId) {
        this.passengerdetailsId = passengerdetailsId;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
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

    public String getNumberPassport() {
        return NumberPassport;
    }

    public void setNumberPassport(String numberPassport) {
        NumberPassport = numberPassport;
    }
}
