package com.regulus.airportservice.Dtos;

import javax.persistence.Column;

public class AirportDto {


    private int airport_id;
    private String iata;
    private String icao;
    @Column(unique = true)
    private String airport_name;

    private int airportGeo_id;

    private String airportGeo_city;

    private  String airportGeo_country;

    public AirportDto() {
    }

    public AirportDto(int airport_id, String iata, String icao,
                      String airport_name,int airportGeo_id,
                      String airportGeo_city, String airportGeo_country) {
        this.airport_id = airport_id;
        this.iata = iata;
        this.icao = icao;
        this.airport_name = airport_name;
        this.airportGeo_id = airportGeo_id;
        this.airportGeo_city = airportGeo_city;
        this.airportGeo_country = airportGeo_country;
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

    public String getAirportGeo_city() {
        return airportGeo_city;
    }

    public void setAirportGeo_city(String airportGeo_city) {
        this.airportGeo_city = airportGeo_city;
    }

    public String getAirportGeo_country() {
        return airportGeo_country;
    }

    public void setAirportGeo_country(String airportGeo_country) {
        this.airportGeo_country = airportGeo_country;
    }


}
