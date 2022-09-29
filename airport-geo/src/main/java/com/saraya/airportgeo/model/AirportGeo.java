package com.saraya.airportgeo.model;

import javax.persistence.*;

@Entity
@Table(name="airportgeo")
public class AirportGeo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Column(unique = true)
    private String country;
    private String city;

}
