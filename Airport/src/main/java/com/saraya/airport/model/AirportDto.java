package com.saraya.airport.model;

public class AirportDto {

    private   Long airport_id;
    private String iata;
    private String icao;
    private  String airport_name;
    private String airportGeoCountry;
    private String airportGeoCity;

    public Long getAirport_id() {
        return airport_id;
    }

    public void setAirport_id(Long airport_id) {
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

    public String getAirportGeoCountry() {
        return airportGeoCountry;
    }

    public void setAirportGeoCountry(String airportGeoCountry) {
        this.airportGeoCountry = airportGeoCountry;
    }

    public String getAirportGeoCity() {
        return airportGeoCity;
    }

    public void setAirportGeoCity(String airportGeoCity) {
        this.airportGeoCity = airportGeoCity;
    }
}
