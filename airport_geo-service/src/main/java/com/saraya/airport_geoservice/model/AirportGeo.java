package com.saraya.airport_geoservice.model;



import javax.persistence.*;

@Entity
public class AirportGeo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airport_geo_id;

    @Column(unique = true, nullable = false)
    private String country;

    @Column(unique = true, nullable = false)
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
