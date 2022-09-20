package com.example.servicesservice.model;

import javax.persistence.*;

@Entity
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long services_id;

    @Column(unique = true)
    private String services_name;


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
