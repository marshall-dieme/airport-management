package com.saraya.servicesservice.dto;

import java.io.Serializable;

public class ServicesDto implements Serializable {
    private  Long services_id;
    private  String services_name;

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
}
