package com.saraya.airline.service;

import com.saraya.airline.model.Airline;
import com.saraya.airline.repository.AirlineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineService {
    private final AirlineRepository repo;

    public AirlineService(AirlineRepository repo) {
        this.repo = repo;
    }

    public List<Airline> getAllAirline(){
        return repo.findAll();
    }

    public  Airline getAirlineId(Long airline_id){
        return repo.findById(airline_id).orElse(null);
    }

    public Airline createAirline(Airline airline){
        return repo.save(airline);
    }


    public Airline updateAirline(Airline airline){
        return repo.save(airline);

    }

    public void deleteAirline(Long airline_id){
        repo.deleteById(airline_id);
    }
    public long getAirlineId(String airline_name, String iata){
        return repo.getIdAirline(airline_name,iata);
    }
}
