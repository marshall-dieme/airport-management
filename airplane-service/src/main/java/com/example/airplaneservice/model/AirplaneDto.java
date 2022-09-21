package com.example.airplaneservice.model;

public class AirplaneDto {
    private Long airplane_id;

    private Long capacity;

    private String airline_name;

    public Long getAirplane_id() {
        return airplane_id;
    }

    public void setAirplane_id(Long airplane_id) {
        this.airplane_id = airplane_id;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public String getAirline_name() {
        return airline_name;
    }

    public void setAirline_name(String airline_name) {
        this.airline_name = airline_name;
    }
}
