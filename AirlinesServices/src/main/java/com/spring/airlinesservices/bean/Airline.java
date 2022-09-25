package com.spring.airlinesservices.bean;

import javax.persistence.*;

@Entity
@Table(name="Airline")
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int airlineId;

    @Column(unique = true)
    private String airlineName;

    private String iata;

    private int airportId;

    private String iacao;

    public Airline() {
    }

    public Airline(int airlineId, String airlineName, String iata) {
        this.airlineId = airlineId;
        this.airlineName = airlineName;
        this.iata = iata;
    }

    public Airline(int airlineId, String airlineName, String iata, int airportId, String iacao) {
        this.airlineId = airlineId;
        this.airlineName = airlineName;
        this.iata = iata;
        this.airportId = airportId;
        this.iacao = iacao;
    }

    public int getAirportId() {
        return airportId;
    }

    public void setAirportId(int airportId) {
        this.airportId = airportId;
    }

    public String getIacao() {
        return iacao;
    }

    public void setIacao(String iacao) {
        this.iacao = iacao;
    }

    public int getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(int airlineId) {
        this.airlineId = airlineId;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }
}
