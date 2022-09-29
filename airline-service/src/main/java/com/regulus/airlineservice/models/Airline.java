package com.regulus.airlineservice.models;


import javax.persistence.*;

@Entity
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int airline_id;

    @Column(unique = true)
    private String airline_name;

    private String iata;

    private int airport_id;

    public Airline() {
    }

    public Airline(int airline_id, String airline_name, String iata, int airport_id) {
        this.airline_id = airline_id;
        this.airline_name = airline_name;
        this.iata = iata;
        this.airport_id = airport_id;
    }

    public int getAirline_id() {
        return airline_id;
    }

    public void setAirline_id(int airline_id) {
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

    public int getAirport_id() {
        return airport_id;
    }

    public void setAirport_id(int airport_id) {
        this.airport_id = airport_id;
    }
}
