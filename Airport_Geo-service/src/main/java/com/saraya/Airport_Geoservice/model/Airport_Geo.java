package com.saraya.Airport_Geoservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Airport_Geo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long airport_geo_id;
    private String country;
    private String city;

    public Airport_Geo() {

    }
    public Airport_Geo(long airport_geo_id, String country, String city) {
        this.airport_geo_id = airport_geo_id;
        this.country = country;
        this.city = city;
    }



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
