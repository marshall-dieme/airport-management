package com.saraya.servicesservice.model;

import javax.persistence.*;

@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int airport_id;

    private String iata;

    private String icao;

    private String airport_name;

    @OneToOne
    private AirportGeo airportGeo;

    public Airport() {
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

    public AirportGeo getAirportGeo() {
        return airportGeo;
    }

    public void setAirportGeo(AirportGeo airportGeo) {
        this.airportGeo = airportGeo;
    }

    public Airport(int airport_id, String iata, String icao, String airport_name, AirportGeo airportGeo) {
        this.airport_id = airport_id;
        this.iata = iata;
        this.icao = icao;
        this.airport_name = airport_name;
        this.airportGeo = airportGeo;
    }
}
