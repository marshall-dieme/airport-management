package com.saraya.airportservice.model;

public class AirportDto {


    private Long airport_id;
    private String iata;
    private String icao;
    private String airport_name;
    private String airport_country;
    private String airport_city;


    public AirportDto() {
    }

    public AirportDto(Long airport_id, String iata, String icao, String airport_name, String airport_country, String airport_city) {
        this.airport_id = airport_id;
        this.iata = iata;
        this.icao = icao;
        this.airport_name = airport_name;
        this.airport_country=airport_country;
        this.airport_city= airport_city;
    }

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

    public String getAirport_country() {
        return airport_country;
    }

    public void setAirport_country(String airport_country) {
        this.airport_country = airport_country;
    }

    public String getAirport_city() {
        return airport_city;
    }

    public void setAirport_city(String airport_city) {
        this.airport_city = airport_city;
    }
}
