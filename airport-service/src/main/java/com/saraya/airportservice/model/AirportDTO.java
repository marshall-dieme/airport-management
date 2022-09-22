package com.saraya.airportservice.model;

public class AirportDTO {

    private int airport_id;

    private String iata;

    private String icao;

    private String airport_name;

    private int airport_geo_id;

    private int airline_id;

    private int service_id;

    private String country;

    private String city;

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

    public Integer getAirport_geo_id() {
        return airport_geo_id;
    }

    public void setAirport_geo_id(int airport_geo_id) {
        this.airport_geo_id = airport_geo_id;
    }

    public int getAirline_id() {
        return airline_id;
    }

    public void setAirline_id(int airline_id) {
        this.airline_id = airline_id;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
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

    public AirportDTO(int airport_id, String iata, String icao, String airport_name, int airport_geo_id, int airline_id, int service_id) {
        this.airport_id = airport_id;
        this.iata = iata;
        this.icao = icao;
        this.airport_name = airport_name;
        this.airport_geo_id = airport_geo_id;
        this.airline_id = airline_id;
        this.service_id = service_id;
    }
}
