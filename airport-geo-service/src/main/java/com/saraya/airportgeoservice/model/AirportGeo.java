package com.saraya.airportgeoservice.model;

import javax.persistence.*;

@Entity
public class AirportGeo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long airport_geo_id;


    @Column(unique = true)
    private String country;


    @Column(unique = true)
    private String city;

    public long getAirport_geo_id() {
        return airport_geo_id;
    }

    public void setAirport_geo_id(long airport_geo_id) {
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
