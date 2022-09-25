package com.saraya.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saraya.booking.dto.BookingDTO;
import com.saraya.booking.service.BookingSrevices;

@RestController
public class BookingController {
	@Autowired
	private BookingSrevices bookingSrevices;
	@PostMapping("/")
	public BookingDTO create(@RequestBody BookingDTO bookingDTO) {
		return bookingSrevices.createBooking(bookingDTO);
	}
	
	@GetMapping("/list")
	public List<BookingDTO> retrievePassengerDetails() {
		return bookingSrevices.getAllBooking();
	}
	
	@GetMapping("/{id}")
	public BookingDTO create(@PathVariable Long id) {
		return bookingSrevices.getBooking(id);
	}
	
	@PutMapping("/update/{id}")
	public BookingDTO update(@RequestBody BookingDTO bookingDTO, @PathVariable Long id) {
		return bookingSrevices.updateBooking(bookingDTO, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		bookingSrevices.delete(id);
	}
}
