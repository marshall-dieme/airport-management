package com.saraya.flightservice.dto;

public class FlightDto {

    private int id;

    private String flightNo;

    private String depatureDate;

    private String arriveDAte;

    private String from;

    private String to;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getDepatureDate() {
        return depatureDate;
    }

    public void setDepatureDate(String depatureDate) {
        this.depatureDate = depatureDate;
    }

    public String getArriveDAte() {
        return arriveDAte;
    }

    public void setArriveDAte(String arriveDAte) {
        this.arriveDAte = arriveDAte;
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
}
