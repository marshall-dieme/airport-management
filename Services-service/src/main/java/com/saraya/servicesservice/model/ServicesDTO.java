package com.saraya.servicesservice.model;

public class ServicesDTO {

    private int serviceId;
    private String servicesName;
    private int airportId;
    private int employeeId;
    private String airportName;

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

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public ServicesDTO(int serviceId, String servicesName, int airportId, int employeeId, String airportName) {
        this.serviceId = serviceId;
        this.servicesName = servicesName;
        this.airportId = airportId;
        this.employeeId = employeeId;
        this.airportName = airportName;
    }
}
