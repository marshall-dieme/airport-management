package com.regulus.bookingservice.dtos;

public class BookingDto {

    private int booking_id;

    private int seat;

    private double price;

    public BookingDto(int booking_id, int seat, double price) {
        this.booking_id = booking_id;
        this.seat = seat;
        this.price = price;
    }

    public BookingDto() {
    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
