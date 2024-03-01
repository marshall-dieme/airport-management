package com.saraya.airportservice.dto;

import java.util.List;

public class AirportDto {
    private int airportId;

    private List<String> nameServices;

    private boolean iata;

    private boolean icao;

     private int airportGeoId;

     private String name;

    public int getAirportId() {
        return airportId;
    }

    public void setAirportId(int airportId) {
        this.airportId = airportId;
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

    public int getAirportGeoId() {
        return airportGeoId;
    }

    public void setAirportGeoId(int airportGeoId) {
        this.airportGeoId = airportGeoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<String> getNameServices() {
        return nameServices;
    }

    public void setNameServices(List<String> nameServices) {
        this.nameServices = nameServices;
    }
}
