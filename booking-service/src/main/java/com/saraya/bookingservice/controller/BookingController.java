package com.saraya.bookingservice.controller;

import com.saraya.bookingservice.bean.Booking;
import com.saraya.bookingservice.dto.BookingDto;
import com.saraya.bookingservice.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Booking")
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @GetMapping
    public List<Booking> getAll(){
        return service.getAll();
    }

    @GetMapping("/{price}")
    public int idBooking(@PathVariable("price") int price){
        return service.getId(price);
    }

    @PostMapping
    public Booking create(@RequestBody BookingDto dto){
        return service.create(dto);
    }

    @PostMapping("/flight/{bookingId}/{flightNo}")
    public Booking putFlightForBooking(@PathVariable("bookingId") int bookingId, @PathVariable("flightNo") int flightNo){
        return service.putFlightForBooking(bookingId, flightNo);
    }

    @PostMapping("/passenger/{bookingId}/{passportNo}")
    public Booking putPassengerForBooking(@PathVariable("bookingId") int bookingId, @PathVariable("passportNo") int passportNo){
        return service.putPassengerForBooking(bookingId, passportNo);
    }
}
