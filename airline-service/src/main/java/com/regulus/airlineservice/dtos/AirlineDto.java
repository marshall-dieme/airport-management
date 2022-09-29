package com.regulus.airlineservice.dtos;

public class AirlineDto {

    private int airline_id;

    private String airline_name;

    private String iata;

    private int airport_id;

    private String airport_name;
    public AirlineDto() {
    }

    public AirlineDto(int airline_id, String airline_name, String iata, int airport_id, String airport_name) {
        this.airline_id = airline_id;
        this.airline_name = airline_name;
        this.iata = iata;
        this.airport_id=airport_id;
        this.airport_name=airport_name;
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

    public String getAirport_name() {
        return airport_name;
    }

    public void setAirport_name(String airport_name) {
        this.airport_name = airport_name;
    }
}
