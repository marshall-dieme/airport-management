package com.regulus.airplaneservice.dtos;

public class AirplaneDto {

    private int airplane_id;

    private int capacity;

    private int airline_id;

    private String airline_name;

    private int airplaneType_id;

    private String airplane_type_identifier;

    private int flight_id;

    private String flight_no;

    public AirplaneDto(int airplane_id, int capacity, int airline_id, String airline_name, int airplaneType_id, String airplane_type_identifier, int flight_id, String flight_no) {
        this.airplane_id = airplane_id;
        this.capacity = capacity;
        this.airline_id = airline_id;
        this.airline_name = airline_name;
        this.airplaneType_id = airplaneType_id;
        this.airplane_type_identifier = airplane_type_identifier;
        this.flight_id = flight_id;
        this.flight_no = flight_no;
    }

    public AirplaneDto() {
    }

    public int getAirplane_id() {
        return airplane_id;
    }

    public void setAirplane_id(int airplane_id) {
        this.airplane_id = airplane_id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getAirline_id() {
        return airline_id;
    }

    public void setAirline_id(int airline_id) {
        this.airline_id = airline_id;
    }

    public String getAirline_name() {
        return airline_name;
    }

    public void setAirline_name(String airline_name) {
        this.airline_name = airline_name;
    }

    public int getAirplaneType_id() {
        return airplaneType_id;
    }

    public void setAirplaneType_id(int airplaneType_id) {
        this.airplaneType_id = airplaneType_id;
    }

    public String getAirplane_type_identifier() {
        return airplane_type_identifier;
    }

    public void setAirplane_type_identifier(String airplane_type_identifier) {
        this.airplane_type_identifier = airplane_type_identifier;
    }

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    public String getFlight_no() {
        return flight_no;
    }

    public void setFlight_no(String flight_no) {
        this.flight_no = flight_no;
    }
}
