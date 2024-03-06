package com.saraya.airport_geo_service.model;

import javax.persistence.*;

@Entity
public class Airport_Geo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
     @Column(name = "airport_geo_id", nullable = false)
    private Long airport_geo_id;

    @Column (unique= true)
    private String country;

    private String city;

    public Airport_Geo(Long airport_geo_id) {
        this.airport_geo_id = airport_geo_id;
    }

    public Airport_Geo() {
    }

    public Airport_Geo(Long airport_geo_id, String country, String city) {
        this.airport_geo_id = airport_geo_id;
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

    public void setCountry(String contry) {
        this.country = contry;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
