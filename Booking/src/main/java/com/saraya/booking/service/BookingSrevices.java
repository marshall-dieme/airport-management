package com.saraya.booking.service;

import java.util.List;

import com.saraya.booking.dto.BookingDTO;

public interface BookingSrevices {
	BookingDTO createBooking(BookingDTO bookingDTO);
	List<BookingDTO> getAllBooking();
	BookingDTO getBooking(Long id);
	BookingDTO updateBooking(BookingDTO bookingDTO, Long id);
	void delete(Long id);
}
