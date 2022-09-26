package com.example.bookingservice.service;

import com.example.bookingservice.model.Booking;
import com.example.bookingservice.repos.BookingRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class BookingService {
    private final BookingRepo repo;

    public BookingService(BookingRepo repo) {
        this.repo = repo;
    }


    public List<Booking> getAll(){
        return repo.findAll();

    }



    public Long getBookingId(String seat,Double price) {
        return repo.getBookingId(seat, price);
    }


    public Booking create(Booking booking){
        return repo.save(booking);
    }

    public Booking update(Booking booking){
        return repo.save(booking);
    }






    public void delete(Long id ){
        repo.deleteById(id);
    }
}
