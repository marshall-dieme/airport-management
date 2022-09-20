package com.saraya.airportservice.model;

import javax.persistence.*;

@Entity
public class AirportGeo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int airport_geo_id;

    private String country;

    private String city;

    @OneToOne
    private AirportGeo airportGeo;

    public AirportGeo() {
    }

    public int getAirport_geo_id() {
        return airport_geo_id;
    }

    public void setAirport_geo_id(int airport_geo_id) {
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

    public AirportGeo getAirportGeo() {
        return airportGeo;
    }

    public void setAirportGeo(AirportGeo airportGeo) {
        this.airportGeo = airportGeo;
    }

    public AirportGeo(int airport_geo_id, String country, String city, AirportGeo airportGeo) {
        this.airport_geo_id = airport_geo_id;
        this.country = country;
        this.city = city;
        this.airportGeo = airportGeo;
    }
}
