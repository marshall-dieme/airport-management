package com.saraya.Bookingservice.controller;

import com.saraya.Bookingservice.dto.BookingDto;
import com.saraya.Bookingservice.model.Booking;
import com.saraya.Bookingservice.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("bookings")
@RestController
public class BookingRestController {

    private final BookingService bookingService;

    @GetMapping
    public ResponseEntity<List<BookingDto>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @GetMapping("/{booking_id}")
    public ResponseEntity<BookingDto> getBooking(@PathVariable Long booking_id) {
        return ResponseEntity.ok(bookingService.getBooking(booking_id));
    }

    @PostMapping
    public ResponseEntity<Booking> saveBooking(@RequestBody BookingDto booking) {
        return new ResponseEntity<>(bookingService.saveBooking(booking), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Booking> updateBooking(@RequestBody BookingDto booking) {
        return  ResponseEntity.ok(bookingService.updateBooking(booking));
    }

    @DeleteMapping("/{booking_id}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long booking_id) {
        bookingService.deleteBooking(booking_id);
        return ResponseEntity.ok("Booking "+booking_id+ " was deleted successfully");
    }
}
