package com.regulus.airportservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int airport_id;
    private String iata;
    private String icao;
    private String airport_name;

    private int airportGeo_id;

    public Airport() {
    }

    public Airport(int airport_id, String iata, String icao, String airport_name, int airportGeo_id) {
        this.airport_id = airport_id;
        this.iata = iata;
        this.icao = icao;
        this.airport_name = airport_name;
        this.airportGeo_id = airportGeo_id;
    }

    public int getAirport_id() {
        return airport_id;
    }

    public void setAirport_id(int airport_id) {
        this.airport_id = airport_id;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public String getAirport_name() {
        return airport_name;
    }

    public void setAirport_name(String airport_name) {
        this.airport_name = airport_name;
    }

    public int getAirportGeo_id() {
        return airportGeo_id;
    }

    public void setAirportGeo_id(int airportGeo_id) {
        this.airportGeo_id = airportGeo_id;
    }
}
