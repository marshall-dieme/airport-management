package com.spring.airlinesservices.DTO;

public class AirlineDto {
    private int airlineId;

    private String airlineName;

    private String iata;

    private int airportId;

    private String iacao;

    public AirlineDto(int airlineId, String airlineName, String iata, int airportId, String iacao) {
        this.airlineId = airlineId;
        this.airlineName = airlineName;
        this.iata = iata;
        this.airportId = airportId;
        this.iacao = iacao;
    }

    public AirlineDto() {
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
}
