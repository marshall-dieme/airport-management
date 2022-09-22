package com.saraya.airlineservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int airlineId;

    private String airlineName;

    private String iata;

    private String airportName;

    private int airportId;

    public Airline() {
    }

    public int getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(int airlineId) {
        this.airlineId = airlineId;
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

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public int getAirportId() {
        return airportId;
    }

    public void setAirportId(int airportId) {
        this.airportId = airportId;
    }

    public Airline(int airlineId, String airlineName, String iata) {
        this.airlineId = airlineId;
        this.airlineName = airlineName;
        this.iata = iata;
    }
}
