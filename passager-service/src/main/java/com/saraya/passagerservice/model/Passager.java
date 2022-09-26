package com.saraya.passagerservice.model;

import javax.persistence.*;

@Entity
public class Passager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int passagerId;

    @Column(unique = true)
    private String passportNo;

    private String firstName;

    private String lastName;

    private int passagerDetailsId;

    private String telephone;

    private String birthdate;

    private String sex;

    private String street;

    private String city;

    private String country;

    private String email;


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

    public Passager() {
    }

    public int getPassagerId() {
        return passagerId;
    }

    public void setPassagerId(int passagerId) {
        this.passagerId = passagerId;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPassagerDetailsId() {
        return passagerDetailsId;
    }

    public void setPassagerDetailsId(int passagerDetailsId) {
        this.passagerDetailsId = passagerDetailsId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Passager(int passagerId, String passportNo, String firstName, String lastName, int passagerDetailsId, String telephone, String birthdate, String sex, String street, String city, String country, String email) {
        this.passagerId = passagerId;
        this.passportNo = passportNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passagerDetailsId = passagerDetailsId;
        this.telephone = telephone;
        this.birthdate = birthdate;
        this.sex = sex;
        this.street = street;
        this.city = city;
        this.country = country;
        this.email = email;
    }
}
