package com.saraya.airplaneservice.model;

public class AirplaneDTO {

    private int airplaneId;

    private String capacity;

    private int airplaneTypeId;

    private int airlineId;

    private String airplaneTypeIdentifier;

    public String getAirplaneTypeIdentifier() {
        return airplaneTypeIdentifier;
    }

    public void setAirplaneTypeIdentifier(String airplaneTypeIdentifier) {
        this.airplaneTypeIdentifier = airplaneTypeIdentifier;
    }

    public int getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(int airplaneId) {
        this.airplaneId = airplaneId;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public int getAirplaneTypeId() {
        return airplaneTypeId;
    }

    public void setAirplaneTypeId(int airplaneTypeId) {
        this.airplaneTypeId = airplaneTypeId;
    }

    public int getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(int airlineId) {
        this.airlineId = airlineId;
    }

    public AirplaneDTO(int airplaneId, String capacity, int airplaneTypeId, int airlineId) {
        this.airplaneId = airplaneId;
        this.capacity = capacity;
        this.airplaneTypeId = airplaneTypeId;
        this.airlineId = airlineId;
    }
}
