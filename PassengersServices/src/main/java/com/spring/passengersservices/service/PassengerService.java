package com.spring.passengersservices.service;


import com.spring.passengersservices.bean.Passenger;
import com.spring.passengersservices.repository.PassengerRepo;
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
     public Optional<Passenger> getById(int id){
        return repo.findById(id);
    }
    public Passenger create(Passenger passenger){
        return repo.save(passenger);
    }
    public Passenger update(Passenger passenger){
       return repo.save(passenger);
    }
    public void delete(int id){
        repo.deleteById(id);
    }

}
