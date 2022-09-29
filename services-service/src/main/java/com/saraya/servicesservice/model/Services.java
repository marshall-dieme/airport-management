package com.saraya.servicesservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long services_id;

    private Long airport_id;
    private String services_name;

    public Services() {
    }

    public Services(Long services_id, String services_name) {
        this.services_id = services_id;
        this.services_name = services_name;
    }

    public Long getServices_id() {
        return services_id;
    }

    public void setServices_id(Long services_id) {

        this.services_id = services_id;
    }

    public String getServices_name() {
        return services_name;
    }

    public void setServices_name(String services_name) {

        this.services_name = services_name;
    }

    public Long getAirport_id() {
        return airport_id;
    }

    public void setAirport_id(Long airport_id) {
        this.airport_id = airport_id;
    }
}
