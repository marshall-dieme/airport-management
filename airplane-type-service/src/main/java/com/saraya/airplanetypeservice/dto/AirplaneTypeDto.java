package com.saraya.airplanetypeservice.dto;

public class AirplaneTypeDto {

    private int id;

    private String airplaneTypeIdentifier;

    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAirplaneTypeIdentifier() {
        return airplaneTypeIdentifier;
    }

    public void setAirplaneTypeIdentifier(String airplaneTypeIdentifier) {
        this.airplaneTypeIdentifier = airplaneTypeIdentifier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
