package com.saraya.airportservice.bean;

import javax.persistence.*;

@Entity
@Table(name = "Airport")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int airportId;
    private String iata;
    private String iacao;
    private  String airportName;

    public Airport(int airportId, String iata, String iacao, String airportName) {
        this.airportId = airportId;
        this.iata = iata;
        this.iacao = iacao;
        this.airportName = airportName;
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
