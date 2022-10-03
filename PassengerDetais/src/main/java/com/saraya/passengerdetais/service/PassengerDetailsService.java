package com.saraya.passengerdetais.service;

import com.saraya.passengerdetais.model.PassengerDetails;
import com.saraya.passengerdetais.repo.PassengerDetailsRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PassengerDetailsService {

    private final PassengerDetailsRepo repo;

    public PassengerDetailsService(PassengerDetailsRepo repo) {
        this.repo = repo;
    }

    public List<PassengerDetails> getAll(){
        return  repo.findAll();
    }
    public Long getIdPassengerDetails( String email){
        return repo.getIdPassengerDetails(email);
    }


    public PassengerDetails create(PassengerDetails details){

        return repo.save(details);
    }

    public  PassengerDetails update(PassengerDetails details){

        return repo.save(details);
    }


    public  void  deleteById(Long passenger_details_id){
        repo.deleteById(passenger_details_id);
    }
}
