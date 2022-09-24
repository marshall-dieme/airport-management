package com.saraya.servicesservice.model;

import javax.persistence.*;

@Entity
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceId;
    private String servicesName;
    private int airportId;
    private String airportName;

    public Services() {
    }
    public Services(int serviceId, String servicesName, int airportId, String airportName) {
        this.serviceId = serviceId;
        this.servicesName = servicesName;
        this.airportId = airportId;
        this.airportName = airportName;
    }
    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServicesName() {
        return servicesName;
    }

    public void setServicesName(String servicesName) {
        this.servicesName = servicesName;
    }

    public int getAirportId() {
        return airportId;
    }

    public void setAirportId(int airportId) {
        this.airportId = airportId;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

   
}
