package com.regulus.airplaneservice.dtos;

public class AirplaneDto {

    private int airplane_id;

    private int capacity;

    private int airline_id;

    private String airline_name;

    public AirplaneDto(int airplane_id, int capacity, int airline_id, String airline_name) {
        this.airplane_id = airplane_id;
        this.capacity = capacity;
        this.airline_id = airline_id;
        this.airline_name = airline_name;
    }

    public AirplaneDto() {
    }

    public int getAirplane_id() {
        return airplane_id;
    }

    public void setAirplane_id(int airplane_id) {
        this.airplane_id = airplane_id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
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
}
