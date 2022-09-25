package com.saraya.microservice.serviceservice.bean;

import javax.persistence.*;

@Entity
public class Services {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private int service_id;
    private String service_name;

    public Services() {
    }

    public Services(int service_id, String service_name) {
        this.service_id = service_id;
        this.service_name = service_name;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }
}
