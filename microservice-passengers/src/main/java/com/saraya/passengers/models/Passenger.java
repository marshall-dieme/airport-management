package com.saraya.passengers.models;

import javax.persistence.*;

@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passenger_id", nullable = false)
    private Long passenger_id;

    private String passport_no;
    private String firstname;
    private String lastname;

    public Passenger() {
    }

    public Passenger(Long passenger_id, String passport_no, String firstname, String lastname) {
        this.passenger_id = passenger_id;
        this.passport_no = passport_no;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Long getPassenger_id() {
        return passenger_id;
    }

    public void setPassenger_id(Long passenger_id) {
        this.passenger_id = passenger_id;
    }

    public String getPassport_no() {
        return passport_no;
    }

    public void setPassport_no(String passport_no) {
        this.passport_no = passport_no;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
