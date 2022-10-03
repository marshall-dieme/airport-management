package com.saraya.microservicebookings.services;

import com.saraya.microservicebookings.exceptions.ResourceNotFoundException;
import com.saraya.microservicebookings.models.Booking;
import com.saraya.microservicebookings.repositories.BookingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingServiceImp implements BookingService {
    private final BookingRepository bookingRepository;

    public BookingServiceImp(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking add(Booking booking) {
        return this.bookingRepository.save(booking);
    }

    @Override
    public Booking update(Booking booking) {
        return this.bookingRepository.save(booking);
    }

    @Override
    public Booking getBooking(Long booking_id) throws ResourceNotFoundException {
        Optional<Booking> booking = this.bookingRepository.findById(booking_id);
        if (!booking.isPresent())
            throw new ResourceNotFoundException("Booking not available");
        return booking.get();
    }

    @Override
    public Page<Booking> getBookings(Pageable pageable) {
        return this.bookingRepository.findAll(pageable);
    }

    @Override
    public void delete(Long booking_id) throws ResourceNotFoundException {
      if (!this.existBooking(booking_id))
          throw new ResourceNotFoundException("impossible to remove this Booking");

      this.bookingRepository.deleteById(booking_id);
    }

    @Override
    public boolean existBooking(Long booking_id) {
        return this.bookingRepository.existsById(booking_id);
    }
}
