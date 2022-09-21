package com.saraya.airlineservice.model;

public class AirlineDTO {

    private int airline_id;

    private String airlineName;

    private String iata;

    private int airplane_id;

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

    public int getAirplane_id() {
        return airplane_id;
    }

    public void setAirplane_id(int airplane_id) {
        this.airplane_id = airplane_id;
    }

    public AirlineDTO(int airline_id, String airlineName, String iata, int airplane_id) {
        this.airline_id = airline_id;
        this.airlineName = airlineName;
        this.iata = iata;
        this.airplane_id = airplane_id;
    }

    public Integer airplane_id() {
        return airplane_id;
    }
}
