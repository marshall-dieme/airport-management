package com.saraya.microserviceflights.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id", nullable = false)
    private Long flight_id;

    private String flight_no;
    private LocalDate departure_date;
    private String from;
    private String to;

    public Flight() {
    }

    public Flight(Long flight_id, String flight_no, LocalDate departure_date, String from, String to) {
        this.flight_id = flight_id;
        this.flight_no = flight_no;
        this.departure_date = departure_date;
        this.from = from;
        this.to = to;
    }

    public Long getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(Long flight_id) {
        this.flight_id = flight_id;
    }

    public String getFlight_no() {
        return flight_no;
    }

    public void setFlight_no(String flight_no) {
        this.flight_no = flight_no;
    }

    public LocalDate getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(LocalDate departure_date) {
        this.departure_date = departure_date;
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
