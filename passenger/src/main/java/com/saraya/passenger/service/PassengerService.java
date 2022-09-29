package com.saraya.passenger.service;

import com.saraya.passenger.model.Passenger;
import com.saraya.passenger.repo.PassengerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService<PassengerRepo> {
    private final PassengerRepository repo;

    public PassengerService(PassengerRepository repo) {
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
    public void delete(Double id){
        repo.deleteById(id);
    }
    public Double getIdPassenger(String passport_no,
    String firstname,
    String  lastname){
       return repo.getIdPassengerByPassport_noAndFirstnameAndLastname(passport_no, firstname, lastname);
    }
    public void deleteByPassport_noAndFirstnameAndLastname(String passport_no,
                                                           String firstname,
                                                           String  lastname){
        repo.deleteByPassport_noAndFirstnameAndLastname(passport_no,
                firstname,
                lastname);
    }
}
