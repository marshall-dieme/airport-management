package com.saraya.airline.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airline_id;

    private Long airport_id;
    private String airline_name;
    private String iata;

    public Airline() {
    }

    public Airline(Long airline_id, Long airport_id, String airline_name, String iata) {
        this.airline_id = airline_id;
        this.airport_id=airport_id;
        this.airline_name = airline_name;
        this.iata = iata;
    }

    public Long getAirline_id() {
        return airline_id;
    }

    public void setAirline_id(Long airline_id) {
        this.airline_id = airline_id;
    }

    public String getAirline_name() {
        return airline_name;
    }

    public void setAirline_name(String airline_name) {
        this.airline_name = airline_name;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public Long getAirport_id() {
        return airport_id;
    }

    public void setAirport_id(Long airport_id) {
        this.airport_id = airport_id;
    }
}
