package com.regulus.airlineservice.dtos;

public class AirlineDto {

    private int airline_id;

    private String airline_name;

    private String iata;

    private int airplane_id;

    private int airplane_capacity;
    public AirlineDto() {
    }

    public AirlineDto(int airline_id, String airline_name, String iata, int airplane_id, int airplane_capacity) {
        this.airline_id = airline_id;
        this.airline_name = airline_name;
        this.iata = iata;
        this.airplane_id=airplane_id;
        this.airplane_capacity=airplane_capacity;
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

    public int getAirplane_id() {
        return airplane_id;
    }

    public void setAirplane_id(int airplane_id) {
        this.airplane_id = airplane_id;
    }

    public int getAirplane_capacity() {
        return airplane_capacity;
    }

    public void setAirplane_capacity(int airplane_capacity) {
        this.airplane_capacity = airplane_capacity;
    }
}
