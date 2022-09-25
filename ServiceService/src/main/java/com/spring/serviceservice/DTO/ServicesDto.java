package com.spring.serviceservice.DTO;

public class ServicesDto {
    private int id;
    private String name;
    private int airportId;

    private String airportName;

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public ServicesDto(int id, String name, int airportId) {
        this.id = id;
        this.name = name;
        this.airportId = airportId;
    }

    public int getAirportId() {
        return airportId;
    }

    public void setAirportId(int airportId) {
        this.airportId = airportId;
    }

    public ServicesDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ServicesDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
