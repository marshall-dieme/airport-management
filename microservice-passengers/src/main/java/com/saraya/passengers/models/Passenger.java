package com.saraya.passengers.models;

import javax.persistence.*;

@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passenger_id", nullable = false)
    private Long airline_id;

    private String passport_no;
    private String firstname;
    private String lastname;

    public Passenger() {
    }

    public Passenger(Long airline_id, String passport_no, String firstname, String lastname) {
        this.airline_id = airline_id;
        this.passport_no = passport_no;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
