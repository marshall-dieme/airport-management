package com.saraya.passengerdetails.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class PassengerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passenger_details_id", nullable = false)
    private Long passenger_details_id;

    private LocalDate birthdate;
    private String sex;
    private String street;
    private String airplane_name;
    private String city;
    private String zip;
    private String country;
    private String email;
    private String telephone;

    public PassengerDetails() {
    }

    public PassengerDetails(Long passenger_details_id, LocalDate birthdate, String sex, String street, String airplane_name, String city, String zip, String country, String email, String telephone) {
        this.passenger_details_id = passenger_details_id;
        this.birthdate = birthdate;
        this.sex = sex;
        this.street = street;
        this.airplane_name = airplane_name;
        this.city = city;
        this.zip = zip;
        this.country = country;
        this.email = email;
        this.telephone = telephone;
    }

    public Long getPassenger_details_id() {
        return passenger_details_id;
    }

    public void setPassenger_details_id(Long passenger_details_id) {
        this.passenger_details_id = passenger_details_id;
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

    public String getAirplane_name() {
        return airplane_name;
    }

    public void setAirplane_name(String airplane_name) {
        this.airplane_name = airplane_name;
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
