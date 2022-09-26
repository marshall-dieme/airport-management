package com.saraya.airportservice.dto;

import javax.persistence.*;


public class AirportDto {
    private Long airport_id;

    private String iata;
   private String icao;
   private String airport_name;

    public AirportDto() {
    }

    public AirportDto(Long airport_id, String iata, String icao, String airport_name) {
        this.airport_id = airport_id;
        this.iata = iata;
        this.icao = icao;
        this.airport_name = airport_name;
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
}
