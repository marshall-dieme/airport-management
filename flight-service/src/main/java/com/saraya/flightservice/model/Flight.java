package com.saraya.flightservice.model;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightId;

    private String flightNo;

    @Column(columnDefinition = "date")
    private LocalDate departureDate;

    @Column(columnDefinition = "date")
    private LocalDate arrivalDate;

    private String fromm;
    private String too;

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
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


    public String getFromm() {
        return fromm;
    }

    public void setFromm(String fromm) {
        this.fromm = fromm;
    }

    public String getToo() {
        return too;
    }

    public void setToo(String too) {
        this.too = too;
    }
}
