package com.saraya.Booking.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.saraya.Booking.Service.BookingService;
import com.saraya.Booking.model.Booking;


@RestController
@RequestMapping("/booking")
public class BookingController {

	 private final Logger LOGGER = LoggerFactory.getLogger(BookingController.class);

		public final BookingService service ;

		public BookingController(BookingService service) {
			this.service = service;
		}
		
	    @GetMapping
		public List<Booking>  getAll(){
	        return service.getAll();
	        }
	    @GetMapping("/{seat}")
	    public Booking getBySeat(@PathVariable String seat){
	        return service.getBySeat(seat);
	    }
		
	    @PostMapping
	    public Booking create(@RequestBody Booking booking){
	    	LOGGER.info("*********CREATING NEW Booking*****");
	        return service.create(booking);
	    }
	    
	    @PutMapping
	    public Booking update(@RequestBody Booking booking){
	        return service.update(booking);
	    }
	    
	    @DeleteMapping("delete/{bookingId}")
	    public void deleteById(@PathVariable int bookingId){
	        service.deleteById(bookingId);
	    }

	    @DeleteMapping("/{seat}")
	    public void deleteBySeat(@PathVariable String seat){
	        service.deleteBySeat(seat);
	    }

	    @GetMapping("/bookingId/{bookingId}")
	    public Booking findById(@PathVariable int bookingId) {
	        return  service.findByBookingId(bookingId);
	    }


}
