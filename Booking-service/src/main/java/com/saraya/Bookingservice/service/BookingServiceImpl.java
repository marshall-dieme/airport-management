package com.saraya.Bookingservice.service;

import com.saraya.Bookingservice.model.Booking;
import com.saraya.Bookingservice.repository.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BookingServiceImpl implements BookingService{

    private final BookingRepository bookingRepository;

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBooking(Long booking_id) {
        return bookingRepository.findById(booking_id).orElseThrow();
    }

    @Override
    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking updateBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public void deleteBooking(Long booking_id) {
        bookingRepository.deleteById(booking_id);
    }
}
