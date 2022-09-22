package com.saraya.airline.service;

import com.saraya.airline.model.Airline;
import com.saraya.airline.repo.AirlineRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineService {

    private  final  AirlineRepo repo ;

    public AirlineService(AirlineRepo repo) {
        this.repo = repo;
    }

    public List<Airline> getAll(){
        return repo.findAll();
    }
    public  Long getIdAirline(String airline_name){
        return repo.getIdAirline(airline_name);
    }
    public Airline create (Airline airline){
        return repo.save(airline);
    }
    public Airline update(Airline airline){
        return repo.save(airline);
    }
//    public void deleteByName( String airline_name){
//        repo.deleteById(Long.valueOf(airline_name));
//    }
    public void deleteById(Long airline_id){
        repo.deleteById(airline_id);
    }

}
