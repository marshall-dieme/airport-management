package com.microservices.airportgeoservices.entity;


import javax.persistence.*;

@Entity
@Table(name = "airportgeo")
public class AirportGeo {

    @Transient
    private static int cpt = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airport_geo_id;

    @Column(unique = true)
    private String country;

    private String city;


    public AirportGeo() {
    }

    public AirportGeo(Long airport_geo_id, String country, String city) {
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
    public void generateId() {
        this.airport_geo_id = Long.valueOf("AirportGeo_" + ++cpt);
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
