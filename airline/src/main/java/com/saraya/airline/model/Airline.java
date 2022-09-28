package com.saraya.airline.model;

import javax.persistence.*;

@Entity
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airline_id", nullable = false)
    private Long airline_id;

    private String airline_name;

    private String iata;


    public Long getAirline_id() {
        return airline_id;
    }
}