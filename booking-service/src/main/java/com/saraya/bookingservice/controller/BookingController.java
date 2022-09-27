package com.saraya.bookingservice.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saraya.bookingservice.bookingService.BookingService;
import com.saraya.bookingservice.entity.Booking;

@RestController


public class BookingController {
	@Autowired
	private final BookingService service;

	public BookingController(BookingService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/")
	public List<Booking>getAll(){
		return service.getAll();
	}
	
	@PostMapping("/")
	public Booking create(@RequestBody Booking booking) {
		return service.create(booking);
	}
	@PutMapping("/")
	public Booking update(@RequestBody Booking booking) {
		return service.update(booking);
	}
	@DeleteMapping("/")
		public void delete(@PathVariable Long id) {
			 service.delete(id);
		}
	
	}
	


