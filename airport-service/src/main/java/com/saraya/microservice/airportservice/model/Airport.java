package com.saraya.microservice.airportservice.model;


import javax.persistence.*;

@Entity
@Table(name = "airport_data")
public class Airport {
    @Id
    @GeneratedValue( strategy=GenerationType.IDENTITY )
    private Integer airport_id;

    private String iata;

    private String icao;

    private String airport_name;
    private String id;
    //@Transient
    //private static int cpt = 0;


    public Airport() {
    }

    public Airport(String iata, String icao, String airport_name) {
        this.iata = iata;
        this.icao = icao;
        this.airport_name = airport_name;
    }


    public String getAirport_name() {
        return airport_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAirport_id() {
        return airport_id;
    }

    public void setAirport_id(Integer airport_id) {
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

    public String getAirport_name(String airport_name) {
        return this.airport_name;
    }

    public void setAirport_name(String airport_name) {
        this.airport_name = airport_name;
    }
}
