package com.saraya.airlineservice.service;

import com.saraya.airlineservice.model.Airline;
import com.saraya.airlineservice.repository.AirlineRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AirlineService {

    private final AirlineRepository repo;

    public AirlineService(AirlineRepository repo) {
        this.repo = repo;
    }

    public List<Airline> getAll(){
        return repo.findAll();
    }
    public  Airline getByAirlineName(
            String airlineName){
        return repo.findByAirlineName(airlineName);
    }

    public Airline create (Airline airline){
        return repo.save(airline);
    }

    public Airline update(Airline airline){
        return repo.save(airline);
    }

    public void deleteByAirlineName(String airlineName){
        Airline airline = repo.findByAirlineName(airlineName);
        repo.delete(airline);
    }

    public void deleteById(int airline_id){
        repo.deleteById(airline_id);
    }

}
