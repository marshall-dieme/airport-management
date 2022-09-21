package com.saraya.booking.service;

import com.saraya.booking.model.Booking;
import com.saraya.booking.repos.Booking_Repo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookingServices {

    private final Booking_Repo repo;

    public BookingServices(Booking_Repo repo) {
        this.repo = repo;
    }


    public List<Booking> getAll(){ return  repo.findAll();}

    public Booking getById(Long booking_id){
        return repo.findById(booking_id).get();
    }


    public Booking create(Booking book){ return  repo.save(book);}

    public Booking update(Booking book){ return  repo.save (book);}


    public void deleteByName(Long booking_id) {
        repo.deleteById(booking_id);
    }
    public void delete(Long booking_id){
        repo.deleteById(booking_id);
    }
}
