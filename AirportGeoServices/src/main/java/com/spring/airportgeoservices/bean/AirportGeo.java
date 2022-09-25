package com.spring.airportgeoservices.bean;

import javax.persistence.*;

@Entity
@Table(name = "airportgeo")
public class AirportGeo {
    @Transient
    private static int cpt = 0;
    @Id
    private String airportGeoId;
    private String country;
    private String city;

    public AirportGeo(String airportGeoId, String country, String city) {
        this.airportGeoId = airportGeoId;
        this.country = country;
        this.city = city;
    }

    public AirportGeo() {

    }

    public String getAirportGeoId() {
        return airportGeoId;
    }

    public void setAirportGeoId(String airportGeoId) {
        this.airportGeoId = airportGeoId;
    }

    public void generateId() {
        this.airportGeoId = "AIRPORTGEO_" + ++cpt;
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
