package com.saraya.airportservice.model;

import javax.persistence.*;

@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int airportId;

    private String iata;

    private String icao;

    private String airportName;

    private int airportGeoId;

    //private int airlineId;

    //private int serviceId;

    private String country;

    private String city;

    public Airport() {
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


    public int getAirportId() {
        return airportId;
    }

    public void setAirportId(int airportId) {
        this.airportId = airportId;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public int getAirportGeoId() {
        return airportGeoId;
    }

    public void setAirportGeoId(int airportGeoId) {
        this.airportGeoId = airportGeoId;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Airport(int airportId, String iata, String icao, String airportName, int airportGeoId, String country, String city) {
        this.airportId = airportId;
        this.iata = iata;
        this.icao = icao;
        this.airportName = airportName;
        this.airportGeoId = airportGeoId;
        this.country = country;
        this.city = city;
    }
}
