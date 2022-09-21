package com.saraya.servicesservice.model;

public class ServicesDto {

    private Long services_id;
    private String services_name;

    private String airport_name;

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

    public String getAirport_name() {
        return airport_name;
    }

    public void setAirport_name(String airport_name) {
        this.airport_name = airport_name;
    }
}
