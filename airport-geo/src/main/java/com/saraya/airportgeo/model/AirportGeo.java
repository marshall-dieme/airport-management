package com.saraya.airportgeo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AirportGeo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int airportGeoId;

    private String country;

    private String city;

    public AirportGeo() {
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

    public AirportGeo(int airportGeoId, String country, String city) {
        this.airportGeoId = airportGeoId;
        this.country = country;
        this.city = city;
    }
}
