package com.regulus.bookingservice.services;

import com.regulus.bookingservice.dtos.BookingDto;
import com.regulus.bookingservice.models.Booking;
import org.springframework.stereotype.Service;

@Service
public class Mapper {

    public BookingDto toDto(Booking booking){
        BookingDto dto = new BookingDto();
        dto.setBooking_id(booking.getBooking_id());
        dto.setSeat(booking.getSeat());
        dto.setPrice(booking.getPrice());
        return dto;
    }

    public Booking toEntity(BookingDto dto){
        Booking booking = new Booking();
        booking.setBooking_id(dto.getBooking_id());
        booking.setSeat(dto.getSeat());
        booking.setPrice(dto.getPrice());
        return booking;
    }

}
