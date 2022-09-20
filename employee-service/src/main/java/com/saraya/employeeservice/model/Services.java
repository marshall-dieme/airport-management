package com.saraya.employeeservice.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int service_id;

    private String servicesName;

    @OneToMany
    private List<Airport> airports;

    @ManyToMany
    private List<Employee> employees;

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

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Services(int service_id, String servicesName, List<Airport> airports, List<Employee> employees) {
        this.service_id = service_id;
        this.servicesName = servicesName;
        this.airports = airports;
        this.employees = employees;
    }
}
