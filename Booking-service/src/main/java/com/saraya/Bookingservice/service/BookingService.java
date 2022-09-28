package com.saraya.Bookingservice.service;

import com.saraya.Bookingservice.dto.BookingDto;
import com.saraya.Bookingservice.model.Booking;
import com.saraya.Bookingservice.proxies.PassengerProxy;
import com.saraya.Bookingservice.repository.BookingRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    private final PassengerProxy passengerProxy;
    private final ModelMapper mapper;

    public List<BookingDto> getAllBookings() {
        List<BookingDto> dtos = new ArrayList<>();
        for (Booking booking: bookingRepository.findAll()) {
            BookingDto dto = mapper.map(booking, BookingDto.class);
            dto.setPassport_no(passengerProxy.getPassenger(booking.getPassenger_id()).getPassport_no());
            dtos.add(dto);
        }
        return dtos;
    }

    public BookingDto getBooking(Long booking_id) {
        BookingDto dto = new BookingDto();
        Booking booking = bookingRepository.findById(booking_id).orElse(null);
        if (booking != null) {
            dto = mapper.map(booking, BookingDto.class);
            dto.setPassport_no(passengerProxy.getPassenger(booking.getPassenger_id()).getPassport_no());
        }
        return dto;
    }

    public Booking saveBooking(BookingDto dto) {
        Booking booking = mapper.map(dto, Booking.class);
        try {
            booking = bookingRepository.save(getBooking(dto, booking));
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return booking;
    }

    private Booking getBooking(BookingDto dto, Booking booking) {
        booking.setPassenger_id(passengerProxy.getPassengerId(dto.getPassport_no()).getPassenger_id());
        return booking;
    }

    public Booking updateBooking(BookingDto dto) {
        return bookingRepository.save(getBooking(dto, mapper.map(dto, Booking.class)));
    }


    public void deleteBooking(Long booking_id) {
        bookingRepository.deleteById(booking_id);
    }



}
