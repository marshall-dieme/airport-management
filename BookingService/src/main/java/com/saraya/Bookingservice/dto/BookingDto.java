package com.saraya.Bookingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class BookingDto implements Serializable {
    private Long booking_id;
    private int seats;
    private double price;
    private String passport_no;
}
