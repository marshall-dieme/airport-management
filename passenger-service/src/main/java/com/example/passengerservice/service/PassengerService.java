package com.example.passengerservice.service;

import com.example.passengerservice.model.Passenger;
import com.example.passengerservice.repos.PassengerRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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



    public Long getIdPassenger(String passportNo) {
        return repo.getPassengerId(passportNo);
    }


    public Passenger create(Passenger passenger){
        return repo.save(passenger);
    }

    public Passenger update(Passenger passenger){
        return repo.save(passenger);
    }





    public void delete(Long id ){
        repo.deleteById(id);
    }
}
