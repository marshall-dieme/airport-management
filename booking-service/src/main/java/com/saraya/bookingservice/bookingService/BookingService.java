package com.saraya.bookingservice.bookingService;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saraya.bookingservice.entity.Booking;
import com.saraya.bookingservice.repository.BookingRepository;

@Service

public class BookingService {
	@Autowired
	private final BookingRepository repo;

	public BookingService(BookingRepository repo) {
		
		this.repo = repo;
	}
	
	public List<Booking>getAll(){
		return repo.findAll();
	}
	
	public Booking create(Booking booking) {
		return repo.save(booking);
	}
	public Booking update(Booking booking) {
		return repo.save(booking);
	}
	public void delete(Long id ) {
		repo.deleteById(id);
	}
	
	

}
