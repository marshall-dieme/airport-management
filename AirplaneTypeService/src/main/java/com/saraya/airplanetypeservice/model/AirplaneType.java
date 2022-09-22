package com.saraya.airplanetypeservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AirplaneType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int airplaneTypeId;

    private String airplaneTypeIdentifier;

    private String airplaneTypeDescription;

    private int airplaneId;

    public int getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(int airplaneId) {
        this.airplaneId = airplaneId;
    }

    public AirplaneType() {
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

    public String getAirplaneTypeDescription() {
        return airplaneTypeDescription;
    }

    public void setAirplaneTypeDescription(String airplaneTypeDescription) {
        this.airplaneTypeDescription = airplaneTypeDescription;
    }

    public AirplaneType(int airplaneTypeId, String airplaneTypeIdentifier, String airplaneTypeDescription) {
        this.airplaneTypeId = airplaneTypeId;
        this.airplaneTypeIdentifier = airplaneTypeIdentifier;
        this.airplaneTypeDescription = airplaneTypeDescription;
    }
}
