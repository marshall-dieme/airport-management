package com.regulus.serviceservice.dtos;

public class ServiceDto {

    private int service_id;

    private String service_name;

    private int airport_id;

    private String airport_name;

    public ServiceDto() {
    }

    public ServiceDto(int service_id, String service_name, int airport_id, String airport_name) {
        this.service_id = service_id;
        this.service_name = service_name;
        this.airport_id = airport_id;
        this.airport_name = airport_name;
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

    public int getAirport_id() {
        return airport_id;
    }

    public void setAirport_id(int airport_id) {
        this.airport_id = airport_id;
    }

    public String getAirport_name() {
        return airport_name;
    }

    public void setAirport_name(String airport_name) {
        this.airport_name = airport_name;
    }
}
