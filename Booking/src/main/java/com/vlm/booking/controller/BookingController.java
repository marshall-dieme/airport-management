package com.vlm.booking.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vlm.booking.exception.ResourceNotFoundException;
import com.vlm.booking.model.Booking;
import com.vlm.booking.repository.BookingRepository;


@RestController
@RequestMapping("/api/v1/")
public class BookingController {
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@GetMapping("/bookings")
	public List<Booking> getAllBookings(){
		return bookingRepository.findAll();
	}
	
	@PostMapping("/bookings")
	public Booking createBooking(@RequestBody Booking booking) {
		return bookingRepository.save(booking);
	}
	
	@GetMapping("/bookings/{id}")
	public ResponseEntity<Booking> getBookingById(@PathVariable Long id){
		Booking booking = bookingRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Booking not exist with id :" + id));
		return ResponseEntity.ok(booking);
	}
	
	@PutMapping("/bookings/{id}")
	public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking bookingDetails){
		Booking booking = bookingRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Booking not exist with id :" + id));
		
		booking.setSeat(bookingDetails.getSeat());
		booking.setPrice(bookingDetails.getPrice());
		
		Booking updatedBooking = bookingRepository.save(booking);
		return ResponseEntity.ok(updatedBooking);
	}
	
	@DeleteMapping("/bookings/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteBooking(@PathVariable Long id){
		Booking booking = bookingRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Booking not exist with id :" + id));
		
		bookingRepository.delete(booking);
		Map<String, Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
