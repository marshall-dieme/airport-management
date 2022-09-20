package com.saraya.airportservice.model;

import javax.persistence.*;

@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String iata;

    private String icao;

    @Column(unique = true)
    private String airport_name;

    private long idAirportGeo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public long getIdAirportGeo() {
        return idAirportGeo;
    }

    public void setIdAirportGeo(long idAirportGeo) {
        this.idAirportGeo = idAirportGeo;
    }
}
