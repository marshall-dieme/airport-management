package com.saraya.airplaneservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Airplane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int airplaneId;
    private int capacity;
    private int airplaneTypeId;
    private int airlineId;
    private String airplaneTypeIdentifier;

    public Airplane() {
    }
 
    public int getAirplaneId() {
        return airplaneId;
    }
    
    public Airplane(int airplaneId, int capacity, int airplaneTypeId, int airlineId) {
        this.airplaneId = airplaneId;
        this.capacity = capacity;
        this.airplaneTypeId = airplaneTypeId;
        this.airlineId = airlineId;
    }

    public void setAirplaneId(int airplaneId) {
        this.airplaneId = airplaneId;
    }

    public int getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(int airlineId) {
        this.airlineId = airlineId;
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

    public String getAirplaneTypeIdentifier() {
        return airplaneTypeIdentifier;
    }

    public void setAirplaneTypeIdentifier(String airplaneTypeIdentifier) {
        this.airplaneTypeIdentifier = airplaneTypeIdentifier;
    }
    
}
