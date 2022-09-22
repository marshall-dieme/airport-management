package com.saraya.airlineservice.models;

import javax.persistence.*;

@Entity
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airline_id", nullable = false)
    private Long airline_id;

    private String airplane_name;
    private String iata;

    public Airline() {
    }

    public Airline(Long airline_id, String airplane_name, String iata) {
        this.airline_id = airline_id;
        this.airplane_name = airplane_name;
        this.iata = iata;
    }

    public Long getAirline_id() {
        return airline_id;
    }

    public void setAirline_id(Long airline_id) {
        this.airline_id = airline_id;
    }

    public String getAirplane_name() {
        return airplane_name;
    }

    public void setAirplane_name(String airplane_name) {
        this.airplane_name = airplane_name;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }
}
