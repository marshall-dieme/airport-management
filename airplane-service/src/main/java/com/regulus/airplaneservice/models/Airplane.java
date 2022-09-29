package com.regulus.airplaneservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Airplane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int airplane_id;

    private int capacity;

    private int airline_id;

    private int airplaneType_id;

    private int flight_id;

    public Airplane(int airplane_id, int capacity, int airline_id, int airplaneType_id, int flight_id) {
        this.airplane_id = airplane_id;
        this.capacity = capacity;
        this.airline_id = airline_id;
        this.airplaneType_id = airplaneType_id;
        this.flight_id = flight_id;
    }

    public Airplane() {
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

    public int getAirplaneType_id() {
        return airplaneType_id;
    }

    public void setAirplaneType_id(int airplaneType_id) {
        this.airplaneType_id = airplaneType_id;
    }

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }
}
