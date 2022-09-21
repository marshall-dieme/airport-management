package com.microservices.airportservices.entity;


import javax.persistence.*;

@Entity
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airport_id;

    private String iata;

    private String icao;

    private String airportName;

    private Long airport_geo_id;

    private String idServices;

    public Airport() {
    }

    public Airport(Long airport_id, String iata, String icao, String airportName, Long airport_geo_id) {
        this.airport_id = airport_id;
        this.iata = iata;
        this.icao = icao;
        this.airportName = airportName;
        this.airport_geo_id = airport_geo_id;
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

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public Long getAirport_geo_id() {
        return airport_geo_id;
    }

    public void setAirport_geo_id(Long airport_geo_id) {
        this.airport_geo_id = airport_geo_id;
    }

    public String getIdServices() {
        return idServices;
    }

    public void setIdServices(String idServices) {
        this.idServices = idServices;
    }
}
