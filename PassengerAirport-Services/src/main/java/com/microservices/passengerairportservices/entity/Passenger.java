package com.microservices.passengerairportservices.entity;

import javax.persistence.*;


@Entity
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passengerId;

    private String firstName;

    private String lastName;

    private String NumberPassport;

    public Passenger() {
    }

    public Passenger(Long passengerId, String numberPassport, String firstName, String lastName) {
        this.passengerId = passengerId;
        NumberPassport = numberPassport;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public String getNumberPassport() {
        return NumberPassport;
    }

    public void setNumberPassport(String numberPassport) {
        NumberPassport = numberPassport;
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
}

