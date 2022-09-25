package com.spring.passengersdetails.service;


import com.spring.passengersdetails.bean.PassengerDetails;
import com.spring.passengersdetails.repository.PassengerDetailsRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerDetailsService {

    private final PassengerDetailsRepo repo;

    public PassengerDetailsService(PassengerDetailsRepo repo) {
        this.repo = repo;
    }
    public List<PassengerDetails> getAll(){
        return repo.findAll();
    }
    public Optional<PassengerDetails> getById(int id){
        return repo.findById(id);
    }
    public PassengerDetails create(PassengerDetails passengerDetails){
        return repo.save(passengerDetails);
    }
    public PassengerDetails update(PassengerDetails passengerDetails){
       return repo.save(passengerDetails);
    }
    public void delete(int id){
        repo.deleteById(id);
    }

}
