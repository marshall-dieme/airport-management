package com.saraya.Bookingservice.service;


import com.saraya.Bookingservice.model.Booking;

import java.util.List;

public interface BookingService {

    List<Booking> getAllBookings();

    Booking getBooking(Long booking_id);

    Booking saveBooking(Booking booking);

    Booking updateBooking(Booking booking);

    void deleteBooking(Long booking_id);

}
