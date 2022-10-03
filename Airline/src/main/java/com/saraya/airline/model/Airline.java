package com.saraya.airline.model;

import javax.persistence.*;

@Entity
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airline_id", nullable = false)
    private Long airline_id;

    private String airlineName;

    private String iata;

    private Long airportId;

    public Long getAirline_id() {
        return airline_id;
    }

    public void setAirline_id(Long airlineId) {
        this.airline_id = airline_id;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public Long getAirportId() {
        return airportId;
    }

    public void setAirportId(Long airportId) {
        this.airportId = airportId;
    }
}
