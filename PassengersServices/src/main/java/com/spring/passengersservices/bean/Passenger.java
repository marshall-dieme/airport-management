package com.spring.passengersservices.bean;

import javax.persistence.*;

@Entity
@Table(name = "passenger")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int passengerId;

    @Column(unique = true )
    private String passportNo;

    private String firstName;

    private String lastName;

    public Passenger() {
    }

    public Passenger(int passengerId, String passportNo, String firstName, String lastName) {
        this.passengerId = passengerId;
        this.passportNo = passportNo;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
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
}
