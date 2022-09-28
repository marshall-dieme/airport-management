package com.saraya.flightservice.service;

import com.saraya.flightservice.model.Flight;
import com.saraya.flightservice.repository.FlightRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FlightService {

    private final FlightRepository repo;

    public FlightService(FlightRepository repo) {
        this.repo = repo;
    }

    public List<Flight> getAll(){
        return repo.findAll();
    }

    public  Flight getByFlightNo(
            String flightNo){
        return repo.findByFlightNo(flightNo);
    }

    public Flight create (Flight flight){
        return repo.save(flight);
    }

    public Flight update(Flight flight){
        return repo.save(flight);
    }

    public void deleteByFlightNo(
            String flightNo){
        Flight flight = repo.findByFlightNo(flightNo);
        repo.delete(flight);
    }

    public void deleteById(int flightId){
        repo.deleteById(flightId);
    }



}
