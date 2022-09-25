package com.saraya.airportservice.bean;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "airports")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int airportId;

    private boolean iata;

    private boolean icao;

    private int airportGeoId;

    @ElementCollection
    private List<Integer> serviceId;

    @ElementCollection
    private List<Integer> airlineId;

    @Column(unique = true)
    private String name;

    public int getAirportId() {
        return airportId;
    }

    public int getAirportGeoId() {
        return airportGeoId;
    }

    public void setAirportGeoId(int airportGeoId) {
        this.airportGeoId = airportGeoId;
    }

    public void setAirportId(int airportId) {
        this.airportId = airportId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIata() {
        return iata;
    }

    public void setIata(boolean iata) {
        this.iata = iata;
    }

    public boolean isIcao() {
        return icao;
    }

    public void setIcao(boolean icao) {
        this.icao = icao;
    }

    public List<Integer> getServiceId() {
        return serviceId;
    }

    public void setServiceId(List<Integer> serviceId) {
        this.serviceId = serviceId;
    }

    public List<Integer> getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(List<Integer> airlineId) {
        this.airlineId = airlineId;
    }

}
