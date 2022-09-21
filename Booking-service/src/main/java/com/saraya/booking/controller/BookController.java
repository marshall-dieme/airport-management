package com.saraya.booking.controller;

import com.saraya.booking.model.Booking;
import com.saraya.booking.service.BookingServices;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("bookings")
public class BookController {
    private final BookingServices service;

    public BookController(BookingServices service) {
        this.service = service;
    }

    @GetMapping
    public List<Booking> getAll() {
        return service.getAll();
    }

    @GetMapping("/{booking_id}")
    public Booking getByName(@PathVariable Long booking_id) {
        return service.getById(booking_id);
    }

    @PostMapping
    public Booking create(@RequestBody Booking b) {
        return service.create(b);
    }

    @PutMapping
    public Booking update(@RequestBody Booking b) {
        return service.update(b);
    }

    @DeleteMapping("delete/{booking_id}")
    public void deleteByName(@PathVariable Long booking_id) {
        service.deleteByName(booking_id);
    }

    @DeleteMapping("/{booking_id}")
    public void delete(@PathVariable Long booking_id) {
        service.delete(booking_id);
    }
}
