package com.saraya.airportservice.dto;

import java.util.List;

public class AirportDto {
    private int airportId;

    private List<String> nameServices;

    private boolean iata;

    private boolean icao;

     private int airportGeoId;

//    private String country;
//
//    private String city;

    private String name;

//    private List<String> services;

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

//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<String> getServices() {
//        return services;
//    }
//
//    public void setServices(List<String> services) {
//        this.services = services;
//    }

    public List<String> getNameServices() {
        return nameServices;
    }

    public void setNameServices(List<String> nameServices) {
        this.nameServices = nameServices;
    }
}
