package com.saraya.flightservice.bean;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String flightNo;

    private String depatureDate;

    private String arriveDAte;

    private String frome;

    private String toe;

    private int bookingId;

    @ElementCollection
    private List<Integer> airplaneId;



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
        return frome;
    }

    public void setFrom(String from) {
        this.frome = from;
    }

    public String getTo() {
        return toe;
    }

    public void setTo(String to) {
        this.toe = to;
    }

    public List<Integer> getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(List<Integer> airplaneId) {
        this.airplaneId = airplaneId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
}
