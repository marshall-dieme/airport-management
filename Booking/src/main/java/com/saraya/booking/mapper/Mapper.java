package com.saraya.booking.mapper;

import org.springframework.stereotype.Component;

import com.saraya.booking.bean.Booking;
import com.saraya.booking.dto.BookingDTO;
@Component
public class Mapper {
	public Booking toBooking(BookingDTO bookingDTO) {
		Booking booking = new Booking();
		booking.setPrice(bookingDTO.getPrice());
		booking.setSeat(bookingDTO.getSeat());
		return booking;
	}
	
	public BookingDTO toDTO(Booking booking) {
		BookingDTO bookingDTO = new BookingDTO();
		bookingDTO.setPrice(booking.getPrice());
		bookingDTO.setSeat(booking.getSeat());
		return bookingDTO;
	}
}
