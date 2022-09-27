package com.saraya.Bookingservice.service;

import com.saraya.Bookingservice.bean.Passenger;
import com.saraya.Bookingservice.bean.ResponseBookingPassenger;
import com.saraya.Bookingservice.dto.BookingDto;
import com.saraya.Bookingservice.model.Booking;
import com.saraya.Bookingservice.proxies.PassengerProxy;
import com.saraya.Bookingservice.repository.BookingRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BookingServiceImpl implements BookingService{

    private final BookingRepository bookingRepository;
    private final PassengerProxy passengerProxy;
    private final ModelMapper mapper;

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBooking(Long booking_id) {
        return bookingRepository.findById(booking_id).orElseThrow();
    }

    @Override
    public Booking saveBooking(BookingDto dto) {
        Booking booking = mapper.map(dto, Booking.class);
        try {
            Passenger passenger = passengerProxy.getPassengerId(dto.getPassport_no());
            booking.setPassenger_id(passenger.getPassenger_id());
            booking = bookingRepository.save(booking);
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return booking;
    }

    @Override
    public Booking updateBooking(BookingDto dto) {
        return bookingRepository.save(mapper.map(dto, Booking.class));
    }

    @Override
    public void deleteBooking(Long booking_id) {
        bookingRepository.deleteById(booking_id);
    }

    @Override
    public ResponseBookingPassenger getBookingWithPassenger(Long booking_id) {
        ResponseBookingPassenger responseBookingPassenger = new ResponseBookingPassenger();
        Booking booking = bookingRepository.findBookingByBooking_id(booking_id);
        responseBookingPassenger.setBooking(booking);
        responseBookingPassenger.
                setPassenger(passengerProxy
                        .getPassengerId(mapper.map(booking, BookingDto.class).getPassport_no()));
        return responseBookingPassenger;
    }


}
