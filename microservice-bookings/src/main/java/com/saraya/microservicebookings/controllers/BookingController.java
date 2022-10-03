package com.saraya.microservicebookings.controllers;

import com.saraya.microservicebookings.dto.BookingDto;
import com.saraya.microservicebookings.exceptions.ResourceNotFoundException;
import com.saraya.microservicebookings.mappers.BookingMapper;
import com.saraya.microservicebookings.models.Booking;
import com.saraya.microservicebookings.services.BookingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {
    private final BookingService bookingService;
    private final BookingMapper bookingMapper;

    public BookingController(BookingService bookingService, BookingMapper bookingMapper) {
        this.bookingService = bookingService;
        this.bookingMapper = bookingMapper;
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody BookingDto bookingDto){

        Booking booking = bookingService.add(bookingMapper.bookingDtoToBooking(bookingDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(bookingMapper.bookingToBookingDto(booking));
    }
    @GetMapping
    public ResponseEntity<Map<String,Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        List<Booking> bookingList = new ArrayList<>();
        Pageable pageable = PageRequest.of(page, size);
        Page<Booking> bookingPage = this.bookingService.getBookings(pageable);
        bookingList = bookingPage.getContent();
        Map<String,Object>  response = new HashMap<>();
        response.put("bookings",this.bookingMapper.bookingsToBookingDtos(bookingList));
        response.put("currentPage",bookingPage.getNumber());
        response.put("totalItems",bookingPage.getTotalElements());
        response.put("totalPages",bookingPage.getTotalPages());

        if (bookingList.isEmpty())
            return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<BookingDto> findById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id==null || id<1)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        Booking booking = this.bookingService.getBooking(id);

        return new ResponseEntity<BookingDto>(this.bookingMapper.bookingToBookingDto(booking),HttpStatus.OK);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody BookingDto bookingDto, @PathVariable Long id){
        if (id==null || id<1)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        Booking booking = bookingService.update(bookingMapper.bookingDtoToBooking(bookingDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(bookingMapper.bookingToBookingDto(booking));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id==null || id<1)
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
         this.bookingService.delete(id);
         return ResponseEntity.noContent().build();
    }
}
