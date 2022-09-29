package com.regulus.flightservice.dtos;


public class FlightDto {

    private int flight_id;

    private String flight_no;

    private String departure_date;

    private String arrival_date;

    private String from_to;

    private int booking_id;

    private int booking_seat;

    public FlightDto() {
    }

    public FlightDto(int flight_id, String flight_no, String departure_date, String arrival_date, String from_to, int booking_id, int booking_seat) {
        this.flight_id = flight_id;
        this.flight_no = flight_no;
        this.departure_date = departure_date;
        this.arrival_date = arrival_date;
        this.from_to = from_to;
        this.booking_id = booking_id;
        this.booking_seat = booking_seat;
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

    public String getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(String departure_date) {
        this.departure_date = departure_date;
    }

    public String getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(String arrival_date) {
        this.arrival_date = arrival_date;
    }

    public String getFrom_to() {
        return from_to;
    }

    public void setFrom_to(String from_to) {
        this.from_to = from_to;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public int getBooking_seat() {
        return booking_seat;
    }

    public void setBooking_seat(int booking_seat) {
        this.booking_seat = booking_seat;
    }
}
