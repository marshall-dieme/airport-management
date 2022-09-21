package com.saraya.airportservice.bean;

public class AirportDto {
    private int airportId;

    private boolean iata;

    private boolean icao;

     private int airportGeoId;

    private String country;

    private String city;

    private String name;

    public int getAirportId() {
        return airportId;
    }

    public void setAirportId(int airportId) {
        this.airportId = airportId;
    }

    public boolean isIata() {
        return iata;
    }

    public void setIata(boolean iata) {
        this.iata = iata;
    }

    public boolean isIcao() {
        return icao;
    }

    public void setIcao(boolean icao) {
        this.icao = icao;
    }

    public int getAirportGeoId() {
        return airportGeoId;
    }

    public void setAirportGeoId(int airportGeoId) {
        this.airportGeoId = airportGeoId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
