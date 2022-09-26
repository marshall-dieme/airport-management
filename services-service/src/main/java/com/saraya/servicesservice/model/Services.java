package com.saraya.servicesservice.model;

import javax.persistence.*;

@Entity
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;

    @Column(unique = true)
    private String serviceName;

    private Long idAirport;

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Long getIdAirport() {
        return idAirport;
    }

    public void setIdAirport(Long idAirport) {
        this.idAirport = idAirport;
    }
}
