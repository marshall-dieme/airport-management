package com.saraya.airlineservice.model;

public class AirlineDTO {

    private int airline_id;

    private String airlineName;

    private String iata;

    public int getAirline_id() {
        return airline_id;
    }

    public void setAirline_id(int airline_id) {
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

    public AirlineDTO(int airline_id, String airlineName, String iata) {
        this.airline_id = airline_id;
        this.airlineName = airlineName;
        this.iata = iata;
    }
}
