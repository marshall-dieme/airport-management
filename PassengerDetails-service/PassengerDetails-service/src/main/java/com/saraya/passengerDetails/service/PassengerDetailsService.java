package com.saraya.passengerDetails.service;

import com.saraya.passengerDetails.bean.PassengerDetails;
import com.saraya.passengerDetails.repository.PassengerDetailsRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerDetailsService {

    private final PassengerDetailsRepo repo;

    public PassengerDetailsService(PassengerDetailsRepo repo) {
        this.repo = repo;
    }
    public List<PassengerDetails> getAll(){
        return repo.findAll();
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
