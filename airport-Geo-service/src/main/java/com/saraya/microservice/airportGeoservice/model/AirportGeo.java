package com.saraya.microservice.airportGeoservice.model;


import javax.persistence.*;

@Entity
public class AirportGeo {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private Integer airport_geo_id;
    private String country;
    private String city;

    public AirportGeo(String country, String city) {

        this.country = country;
        this.city = city;
    }

    public AirportGeo() {
    }


    public Integer getAirport_geo_id() {
        return airport_geo_id;
    }

    public void setAirport_geo_id(Integer  airport_geo_id) {
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
