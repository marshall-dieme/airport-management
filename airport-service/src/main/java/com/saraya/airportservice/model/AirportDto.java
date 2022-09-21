package com.saraya.airportservice.model;

import javax.persistence.Column;

public class AirportDto {

    private Long id;
    private String iata;

    private String icao;
    private String airport_name;

    private String airportGeoCity;
    private String airportGeoCountry;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAirportGeoCity() {
        return airportGeoCity;
    }

    public void setAirportGeoCity(String airportGeoCity) {
        this.airportGeoCity = airportGeoCity;
    }

    public String getAirportGeoCountry() {
        return airportGeoCountry;
    }

    public void setAirportGeoCountry(String airportGeoCountry) {
        this.airportGeoCountry = airportGeoCountry;
    }
}
