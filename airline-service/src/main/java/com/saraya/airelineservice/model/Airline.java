package com.saraya.airelineservice.model;

import javax.persistence.*;

@Entity
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airline_id;

    @Column(unique = true)
    private String airline_name;

    private String iata;

    private Long idAirport;

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

    public Long getIdAirport() {
        return idAirport;
    }

    public void setIdAirport(Long idAirport) {
        this.idAirport = idAirport;
    }
}