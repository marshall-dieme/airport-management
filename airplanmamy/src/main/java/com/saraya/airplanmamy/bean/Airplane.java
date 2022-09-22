package com.saraya.airplanmamy.bean;

import javax.persistence.*;

@Entity
@Table(name = "airplane")
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int airplaneId;

    private String capacity;

    public Airplane() {
    }

    public Airplane(int airplaneId, String capacity) {
        this.airplaneId = airplaneId;
        this.capacity = capacity;
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
}
