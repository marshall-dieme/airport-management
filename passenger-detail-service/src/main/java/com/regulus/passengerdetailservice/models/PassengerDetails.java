package com.regulus.passengerdetailservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class PassengerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int passenger_details_id;

    private LocalDate birthDate;

    private String sex;

    private String street;

    private String city;

    private String zip;

    private String contry;

    private String email;

    private String telephone;

    private int passenger_id;

    public PassengerDetails(int passenger_details_id, LocalDate birthDate, String sex, String street, String city, String zip, String contry, String email, String telephone, int passenger_id) {
        this.passenger_details_id = passenger_details_id;
        this.birthDate = birthDate;
        this.sex = sex;
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.contry = contry;
        this.email = email;
        this.telephone = telephone;
        this.passenger_id = passenger_id;
    }

    public PassengerDetails() {
    }

    public int getPassenger_details_id() {
        return passenger_details_id;
    }

    public void setPassenger_details_id(int passenger_details_id) {
        this.passenger_details_id = passenger_details_id;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
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

    public String getContry() {
        return contry;
    }

    public void setContry(String contry) {
        this.contry = contry;
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

    public int getPassenger_id() {
        return passenger_id;
    }

    public void setPassenger_id(int passenger_id) {
        this.passenger_id = passenger_id;
    }
}
