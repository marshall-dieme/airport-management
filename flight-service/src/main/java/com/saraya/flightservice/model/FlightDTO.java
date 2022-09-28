package com.saraya.flightservice.model;

import java.time.LocalDate;

public class FlightDTO {

    private int flightId;

    private String flightNo;

    private LocalDate departureDate;

    private LocalDate arrivalDate;

    private String from;

    private String to;

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public FlightDTO(int flightId, String flightNo, LocalDate departureDate, LocalDate arrivalDate, String from, String to) {
        this.flightId = flightId;
        this.flightNo = flightNo;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.from = from;
        this.to = to;
    }
}
