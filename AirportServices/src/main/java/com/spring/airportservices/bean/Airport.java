package com.spring.airportservices.bean;

import javax.persistence.*;

@Entity
@Table(name = "Airport")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int airportId;
    private String iata;
    private String iacao;
    @Column(unique = true)
    private  String airportName;
    private String airportGeoId;

    public Airport(int airportId, String iata, String iacao, String airportName, String airportGeoId) {
        this.airportId = airportId;
        this.iata = iata;
        this.iacao = iacao;
        this.airportName = airportName;
        this.airportGeoId= airportGeoId;
    }


    public String getAirportGeoId() {
        return airportGeoId;
    }

    public void setAirportGeoId(String airportGeoId) {
        this.airportGeoId = airportGeoId;
    }

    public Airport() {

    }

    public int getAirportId() {
        return airportId;
    }

    public void setAirportId(int airportId) {
        this.airportId = airportId;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getIacao() {
        return iacao;
    }

    public void setIacao(String iacao) {
        this.iacao = iacao;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }
}
