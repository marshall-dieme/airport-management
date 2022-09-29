package com.saraya.Bookingservice.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookingDto implements Serializable {
    private Long booking_id;
    private int seats;
    private double price;
    private String passport_no;
}
