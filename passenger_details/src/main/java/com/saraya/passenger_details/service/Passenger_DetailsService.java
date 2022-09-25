package com.saraya.passenger_details.service;

import com.saraya.passenger_details.dtos.Passenger_DetailsDto;
import com.saraya.passenger_details.model.PassengerDetails;
import com.saraya.passenger_details.repository.Passenger_DetailsRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Passenger_DetailsService {
    private final Passenger_DetailsRepo repo;


    public Passenger_DetailsService(Passenger_DetailsRepo repo) {
        this.repo = repo;
    }

    public List<PassengerDetails> getAll() {
        return repo.findAll();
    }

    public PassengerDetails getById(Long id) {
        return repo.findById(id).get();
    }

    public PassengerDetails create(PassengerDetails passengerDetails) {
        return repo.save(passengerDetails);
    }


    public PassengerDetails update(PassengerDetails passengerDetails) {
        return repo.save(passengerDetails);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }


}
