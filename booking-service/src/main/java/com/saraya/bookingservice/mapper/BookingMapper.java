package com.saraya.bookingservice.mapper;

import com.saraya.bookingservice.bean.Booking;
import com.saraya.bookingservice.dto.BookingDto;

public class BookingMapper {
    public Booking toEntity(BookingDto dto) {
        Booking booking = new Booking();
        booking.setPrice(dto.getPrice());
        booking.setSeat(dto.getSeat());
        return booking;
    }
}
