package com.spring.airportservices.DTO;

public class AirportDto {
    private int airportId;
    private String iata;
    private String iacao;
    private  String airportName;
    private String airportGeoId;

    private String city;

    private String country;

    public AirportDto() {
    }

    public AirportDto(int airportId, String iata, String iacao, String airportName, String airportGeoId, String city, String country) {
        this.airportId = airportId;
        this.iata = iata;
        this.iacao = iacao;
        this.airportName = airportName;
        this.airportGeoId = airportGeoId;
        this.city = city;
        this.country = country;
    }

    public AirportDto(int airportId, String iata, String iacao, String airportName, String airportGeoId) {
        this.airportId = airportId;
        this.iata = iata;
        this.iacao = iacao;
        this.airportName = airportName;
        this.airportGeoId = airportGeoId;
    }

    public String getAirportGeoId() {
        return airportGeoId;
    }

    public void setAirportGeoId(String airportGeoId) {
        this.airportGeoId = airportGeoId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }



    public String getAirPortGeo() {
        return airportGeoId;
    }

    public void setAirPortGeo(String airportGeoId) {
        this.airportGeoId = airportGeoId;
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
