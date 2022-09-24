package com.microservices.passengerairportservices.service;

import com.microservices.passengerairportservices.entity.Passenger;
import com.microservices.passengerairportservices.repository.PassengerRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    private final PassengerRepo repo;

    public PassengerService(PassengerRepo repo) {
        this.repo = repo;
    }

    public List<Passenger> getAll(){
        return repo.findAll();
    }
    public Optional<Passenger> getById(Long passengerId) {
        return repo.findById(passengerId);
    }

    public Passenger create(Passenger passenger) {
        return repo.save(passenger);
    }

    public Passenger update(Passenger passenger) {
        return repo.save(passenger);
    }

    public void delete(Long passengerId) {
        repo.deleteById(passengerId);
    }

    public String getIdPassenger(String NumberPassport) {
        return repo.getById(NumberPassport);
    }


}
