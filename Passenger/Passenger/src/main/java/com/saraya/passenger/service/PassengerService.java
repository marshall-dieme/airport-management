package com.saraya.passenger.service;

import com.saraya.passenger.bean.Passenger;
import com.saraya.passenger.repository.PassengerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {
    private final PassengerRepo repo;

    public PassengerService(PassengerRepo repo) {
        this.repo = repo;
    }
    public List<Passenger> getAll(){
        return repo.findAll();
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
