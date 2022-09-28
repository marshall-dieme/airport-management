package com.saraya.bookingservice.model;

public class BookingModelDTO {

    private int bookingId;

    private String seat;

    private Double price;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public BookingModelDTO(int bookingId, String seat, Double price) {
        this.bookingId = bookingId;
        this.seat = seat;
        this.price = price;
    }
}
