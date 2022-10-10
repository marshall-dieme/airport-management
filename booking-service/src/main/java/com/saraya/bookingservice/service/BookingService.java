package com.saraya.bookingservice.service;

import com.saraya.bookingservice.bean.Booking;
import com.saraya.bookingservice.dto.BookingDto;
import com.saraya.bookingservice.mapper.BookingMapper;
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

    private BookingMapper mapper = new BookingMapper();

    public Booking putFlightForBooking(int bookingId, String flightNo) {

        Booking booking = repo.findById(bookingId).get();

        RestTemplate restTemplate = new RestTemplate();
        int flightId = restTemplate.getForEntity("http://localhost:8009/Flight/"+flightNo, Integer.class).getBody();
        booking.getFlightId().add(flightId);

        return repo.save(booking);
    }

    public Booking putPassengerForBooking(int bookingId, int passportNo) {

        Booking booking = repo.findById(bookingId).get();

        RestTemplate restTemplate = new RestTemplate();
        int passengerId = restTemplate.getForEntity("http://localhost:8010/Passenger/"+passportNo, Integer.class).getBody();
        booking.getPassengerId().add(passengerId);

        return repo.save(booking);
    }

    public List<Booking> getAll() {
        return repo.findAll();
    }

    public int getId(int price) {
        return repo.findByPrice(price).getId();
    }

    public Booking create(BookingDto dto) {
        return repo.save(mapper.toEntity(dto));
    }

    public Booking update(BookingDto dto) {
        return repo.save(mapper.toEntity(dto));
    }

    public void delete(BookingDto dto) {
        repo.delete(mapper.toEntity(dto));
    }
}
