package com.saraya.servicesservice.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int service_id;
    private String servicesName;

    private int airport_id;

    private int employee_id;

    public Services() {
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public String getServicesName() {
        return servicesName;
    }

    public void setServicesName(String servicesName) {
        this.servicesName = servicesName;
    }

    public int getAirport_id() {
        return airport_id;
    }

    public void setAirport_id(int airport_id) {
        this.airport_id = airport_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public Services(int service_id, String servicesName, int airport_id, int employee_id) {
        this.service_id = service_id;
        this.servicesName = servicesName;
        this.airport_id = airport_id;
        this.employee_id = employee_id;
    }
}
