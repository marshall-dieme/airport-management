package com.saraya.airlineservice.bean;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "airlines")
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String airlineName;

    private boolean iata;

    private int airportId;

    @ElementCollection
    private List<Integer> airplaneId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public boolean isIata() {
        return iata;
    }

    public void setIata(boolean iata) {
        this.iata = iata;
    }

    public int getAirportId() {
        return airportId;
    }

    public void setAirportId(int airportId) {
        this.airportId = airportId;
    }

    public List<Integer> getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(List<Integer> airplaneId) {
        this.airplaneId = airplaneId;
    }


}
