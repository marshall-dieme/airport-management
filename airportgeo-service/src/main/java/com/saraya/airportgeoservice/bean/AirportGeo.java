package com.saraya.airportgeoservice.bean;

import javax.persistence.*;

@Entity
@Table(name = "airportgeos")
public class AirportGeo {

    @Id
    private String airport_geo_id;

    @Transient
    private static int cpt = 1000;

    private String country;

    private String city;

    public void generateId(){
        this.airport_geo_id = "AprtGeo_"+ ++cpt;
    }

    public String getAirport_geo_id() {
        return airport_geo_id;
    }

    public void setAirport_geo_id(String airport_geo_id) {
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
