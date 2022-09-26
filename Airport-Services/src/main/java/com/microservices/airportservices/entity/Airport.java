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

    private String idGeo;

    public Airport() {
    }

    public Airport(Long airport_id, String iata, String icao, String airportName) {
        this.airport_id = airport_id;
        this.iata = iata;
        this.icao = icao;
        this.airportName = airportName;
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

    public String getIdGeo() {
        return idGeo;
    }

    public void setIdGeo(String idGeo) {
        this.idGeo = idGeo;
    }
}
