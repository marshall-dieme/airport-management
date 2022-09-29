package com.saraya.microservice.airportservice.model;

public class AirportDto {
    private Integer airport_id;

    private String iata;

    private String icao;

    private String airport_name;
    private String country;

    private String city;

    public String getCountry() {
        return country;
    }

    public void setAirport_id(Integer airport_id) {
        this.airport_id = airport_id;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String arp) {
        this.city = arp;
    }

    public AirportDto() {
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
}
