package com.saraya.Bookingservice.service;


import com.saraya.Bookingservice.bean.ResponseBookingPassenger;
import com.saraya.Bookingservice.dto.BookingDto;
import com.saraya.Bookingservice.model.Booking;

import java.util.List;

public interface BookingService {

    List<Booking> getAllBookings();

    Booking getBooking(Long booking_id);

    Booking saveBooking(BookingDto bookingDto);

    Booking updateBooking(BookingDto bookingDto);

    void deleteBooking(Long booking_id);

    ResponseBookingPassenger getBookingWithPassenger(Long booking_id);

}
