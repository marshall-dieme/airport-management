package com.microservices.passengerdetailsairportservices.entity;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class PassengerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passengerdetailsId;

    @Column(columnDefinition = "date")
    private LocalDate birthdate;

    private String sexe;

    private String street;

    private String city;

    private String zip;

    private String country;

    private String email;

    private String telephone;

    private String idPassenger;

    public PassengerDetails() {
    }

    public PassengerDetails(Long passengerdetailsId, LocalDate birthdate, String sexe, String street, String city, String zip, String country, String email, String telephone, String idPassenger) {
        this.passengerdetailsId = passengerdetailsId;
        this.birthdate = birthdate;
        this.sexe = sexe;
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.country = country;
        this.email = email;
        this.telephone = telephone;
        this.idPassenger = idPassenger;
    }

    public Long getPassengerdetailsId() {
        return passengerdetailsId;
    }

    public void setPassengerdetailsId(Long passengerdetailsId) {
        this.passengerdetailsId = passengerdetailsId;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
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

    public String getIdPassenger() {
        return idPassenger;
    }

    public void setIdPassenger(String idPassenger) {
        this.idPassenger = idPassenger;
    }
}

