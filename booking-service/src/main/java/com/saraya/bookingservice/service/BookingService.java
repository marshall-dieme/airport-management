package com.saraya.bookingservice.service;

import com.saraya.bookingservice.bean.Booking;
import com.saraya.bookingservice.dto.BookingDto;
import com.saraya.bookingservice.repository.BookingRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepo repo;

    public BookingService(BookingRepo repo) {
        this.repo = repo;
    }

    public List<Booking> getAll() {
        return repo.findAll();
    }

    public int getId(int price) {
        return repo.findByPrice(price).getId();
    }

    public Booking create(BookingDto dto) {
        return repo.save(toEntity(dto));
    }

    private Booking toEntity(BookingDto dto) {
        Booking booking = new Booking();
        booking.setPrice(dto.getPrice());
        booking.setSeat(dto.getSeat());
        return booking;
    }

    public Booking putFlightForBooking(int bookingId, int flightNo) {

        Booking booking = repo.findById(bookingId).get();

        RestTemplate restTemplate = new RestTemplate();
        int flightId = restTemplate.getForEntity("http://localhost:8009/Flight/"+flightNo, Integer.class).getBody();
        booking.getFlightId().add(flightId);

        return repo.save(booking);
    }
}
