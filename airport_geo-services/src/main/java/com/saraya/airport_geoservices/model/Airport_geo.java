package com.saraya.airport_geoservices.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Airport_geo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airport_geo_id;
    private String country;
    private String city;

    public Airport_geo() {
    }

    public Airport_geo(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public Long getAirport_geo_id() {
        return airport_geo_id;
    }

    public void setAirport_geo_id(Long airport_geo_id) {
        this.airport_geo_id = airport_geo_id;
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

