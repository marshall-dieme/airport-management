package com.saraya.microservicebookings.services;

import com.saraya.microservicebookings.exceptions.ResourceNotFoundException;
import com.saraya.microservicebookings.models.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface BookingService {

    Booking add(Booking booking) throws ResourceNotFoundException;
    Booking update(Booking booking) throws ResourceNotFoundException;
    Booking getBooking(Long booking_id) throws ResourceNotFoundException;
    Page<Booking> getBookings(Pageable pageable);
    void delete(Long booking_id) throws ResourceNotFoundException;
    boolean existBooking(Long booking_id);

}
