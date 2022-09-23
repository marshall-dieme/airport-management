package com.saraya.airlineservice.model;

public class AirlineDTO {

    private int airlineId;
    private String airlineName;
    private String iata;
    private String airportName;

    public AirlineDTO(int airlineId, String airlineName, String iata) {
        this.airlineId = airlineId;
        this.airlineName = airlineName;
        this.iata = iata;
    }

    public int getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(int airlineId) {
        this.airlineId = airlineId;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
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

   
    
}
