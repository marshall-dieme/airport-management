package com.saraya.Bookingservice.bean;

import com.saraya.Bookingservice.model.Booking;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseBookingPassenger {
    private Booking booking;
    private Passenger passenger;
}
