package com.saraya.airplaneservice.model;

public class AirplaneDTO {

    private int airplaneId;
    private int capacity;
    private int airplaneTypeId;
    private int airlineId;
    private String airplaneTypeIdentifier;
    
    

    public AirplaneDTO() {
	}
    
    public AirplaneDTO(int airplaneId, int capacity, int airplaneTypeId, int airlineId) {
        this.airplaneId = airplaneId;
        this.capacity = capacity;
        this.airplaneTypeId = airplaneTypeId;
        this.airlineId = airlineId;
    }

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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
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

   
}
