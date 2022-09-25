package com.saraya.airlineservice.dto;

public class AirlineDto {

    private int id;

    private String airlineName;

    private boolean iata;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public boolean isIata() {
        return iata;
    }

    public void setIata(boolean iata) {
        this.iata = iata;
    }
}
