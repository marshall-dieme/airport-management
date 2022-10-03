package com.saraya.servicesservice.model;

import javax.persistence.*;

@Entity
public class Service {
    @Id
    @GeneratedValue
     @Column(name = "service_id", nullable = false)
    private Long service_id;

    @Column (unique= true)
    private String serviceName;
    private  Long airportId;
    public Long getService_id() {
        return service_id;
    }

    public void setService_id(Long service_id) {
        this.service_id = service_id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Long getAirportId() {
        return airportId;
    }

    public void setAirportId(Long airportId) {
        this.airportId = airportId;
    }
}
