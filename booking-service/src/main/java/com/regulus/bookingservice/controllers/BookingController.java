package com.regulus.bookingservice.controllers;

import com.regulus.bookingservice.dtos.BookingDto;
import com.regulus.bookingservice.models.Booking;
import com.regulus.bookingservice.services.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public List<Booking> getBookingList(){
        return bookingService.getBooking();
    }

    @PostMapping
    public BookingDto create(@RequestBody BookingDto bookingDto){
        return bookingService.createBooking(bookingDto);
    }

    @PutMapping("/{id}")
    public BookingDto update(@PathVariable("id") int id, @RequestBody BookingDto bookingDto){
        return bookingService.updateBooking(bookingDto, id);
    }

    @GetMapping("/{id}")
    public BookingDto getBooking(@PathVariable("id") int id ){
        return bookingService.getBooking(id);
    }

    @GetMapping("/seat/{seat}")
    public Integer getBookingId(@PathVariable("seat") int seat){
        return bookingService.getBookingId(seat);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable("id") int id){
        bookingService.deleteBooking(id);
    }
}
