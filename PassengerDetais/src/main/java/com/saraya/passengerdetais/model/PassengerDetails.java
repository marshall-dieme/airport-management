package com.saraya.passengerdetais.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
@Entity
public class PassengerDetails {
    @Id
    @GeneratedValue
    @Column(name = "passenger_details_id", nullable = false)
    private Long passenger_details_id;
    private LocalDate birthdate;
    private String sex;
    private String street;
    private String city;
    private int zip;
    private String country;
    @Column(unique = true)
    private String email;
    private int telephone;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
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
