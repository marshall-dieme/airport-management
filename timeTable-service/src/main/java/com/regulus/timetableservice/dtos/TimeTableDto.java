package com.regulus.timetableservice.dtos;

public class TimeTableDto {

    private int Time_table_id;

    private String flight_from;

    private String flight_to;

    private String airline;

    private String flight_type;

    private String flight_no;

    public TimeTableDto(int time_table_id, String flight_from, String flight_to, String airline, String flight_type, String flight_no) {
        Time_table_id = time_table_id;
        this.flight_from = flight_from;
        this.flight_to = flight_to;
        this.airline = airline;
        this.flight_type = flight_type;
        this.flight_no = flight_no;
    }

    public TimeTableDto() {
    }

    public int getTime_table_id() {
        return Time_table_id;
    }

    public void setTime_table_id(int time_table_id) {
        Time_table_id = time_table_id;
    }

    public String getFlight_from() {
        return flight_from;
    }

    public void setFlight_from(String flight_from) {
        this.flight_from = flight_from;
    }

    public String getFlight_to() {
        return flight_to;
    }

    public void setFlight_to(String flight_to) {
        this.flight_to = flight_to;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getFlight_type() {
        return flight_type;
    }

    public void setFlight_type(String flight_type) {
        this.flight_type = flight_type;
    }

    public String getFlight_no() {
        return flight_no;
    }

    public void setFlight_no(String flight_no) {
        this.flight_no = flight_no;
    }
}
