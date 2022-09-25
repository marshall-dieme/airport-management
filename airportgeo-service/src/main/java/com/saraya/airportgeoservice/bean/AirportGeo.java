package com.saraya.airportgeoservice.bean;

import javax.persistence.*;

@Entity
@Table(name = "airportgeos")
public class AirportGeo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int airportGeoId;

    private String country;

    private String city;

    private int airportId;

    public int getAirportId() {
        return airportId;
    }

    public void setAirportId(int airportId) {
        this.airportId = airportId;
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

}
