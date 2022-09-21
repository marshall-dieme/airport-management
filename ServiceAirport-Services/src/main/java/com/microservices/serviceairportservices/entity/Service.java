package com.microservices.serviceairportservices.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Service {

    @Id
    private String servicesId;

    private String servicesName;

    public Service() {
    }

    public Service(String servicesId, String servicesName) {
        this.servicesId = servicesId;
        this.servicesName = servicesName;
    }

    public String getServicesId() {
        return servicesId;
    }

    public void setServicesId(String servicesId) {
        this.servicesId = servicesId;
    }

    public String getServicesName() {
        return servicesName;
    }

    public void setServicesName(String servicesName) {
        this.servicesName = servicesName;
    }

}
