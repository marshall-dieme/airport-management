package com.example.bookingservice.controller;

import com.example.bookingservice.model.Booking;
import com.example.bookingservice.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }



    @GetMapping
    public List<Booking> getAll(){
        return service.getAll();
    }


    @GetMapping("/seat/price/{seat}/{price}")
    public Long getIdBooking(@PathVariable String seat, @PathVariable Double price){
        return service.getBookingId(seat, price);
    }


    @PostMapping("/")
    public Booking create(@RequestBody Booking booking) {

        return service.create(booking);
    }

    @PutMapping("/")
    public Booking update (@RequestBody Booking booking){
        return service.update(booking);
    }



    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        service.delete(id);
    }
}
