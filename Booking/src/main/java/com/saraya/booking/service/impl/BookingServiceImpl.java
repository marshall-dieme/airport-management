package com.saraya.booking.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.saraya.booking.bean.Booking;
import com.saraya.booking.dto.BookingDTO;
import com.saraya.booking.mapper.Mapper;
import com.saraya.booking.repository.BookingRepository;
import com.saraya.booking.service.BookingSrevices;
@Service
public class BookingServiceImpl implements BookingSrevices {
	@Autowired
	private Mapper mapper;
	@Autowired
	private BookingRepository bookingRepository;
	@Override
	public BookingDTO createBooking(BookingDTO bookingDTO) {
		Booking booking = mapper.toBooking(bookingDTO);
		bookingRepository.save(booking);
		return bookingDTO;
	}

	@Override
	public List<BookingDTO> getAllBooking() {
		List<Booking> bookings = bookingRepository.findAll();
		List<BookingDTO> bookingDTOs = new ArrayList<>();
		for (Booking booking : bookings) {
			BookingDTO dto = mapper.toDTO(booking);
			bookingDTOs.add(dto);
		}
		return bookingDTOs;
	}

	@Override
	public BookingDTO getBooking(Long id) {
		Optional<Booking> optional = bookingRepository.findById(id);
		BookingDTO bookingDTO = null;
		if(optional.isPresent()) {
			Booking booking = optional.get();
			bookingDTO = mapper.toDTO(booking);
		}
		else {
			throw new RuntimeException("the id don't exist check again!!!!!!!!!!!!!!!!!!!!");
		}
		return bookingDTO;
	}

	@Override
	public BookingDTO updateBooking(BookingDTO dto, Long id) {
		Optional<Booking> optional = bookingRepository.findById(id);
		BookingDTO bookingDTO = null;
		if(optional.isPresent()) {
			Booking booking = optional.get();
			booking.setPrice(bookingDTO.getPrice());
			booking.setSeat(bookingDTO.getSeat());
			bookingDTO = mapper.toDTO(booking);
			bookingRepository.save(booking);
		}
		return bookingDTO;
	}

	@Override
	public void delete(Long id) {
		bookingRepository.deleteById(id);
	}

}
