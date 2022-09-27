package com.saraya.airplanetypeservice.bean;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "airplane_types")
public class AirplaneType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String airplaneTypeIdentifier;

    private String description;

    @ElementCollection
    private List<Integer> airplaneId;

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

    public List<Integer> getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(List<Integer> airplaneId) {
        this.airplaneId = airplaneId;
    }
}
