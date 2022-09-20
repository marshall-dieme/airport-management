package com.saraya.airportservice.service;

import com.saraya.airportservice.model.Airport;
import com.saraya.airportservice.repository.AirportRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AirportService {

    private final AirportRepository repo;

    public AirportService(AirportRepository repo) {
        this.repo = repo;
    }

    public List<Airport> getAll(){
        return repo.findAll();
    }

    public Airport getByIata(String iata){
        return repo.findByIata(iata);
    }

    public Airport create (Airport airport){
        return repo.save(airport);
    }

    public Airport update(Airport airport){
        return repo.save(airport);
    }

    public void deleteByIata(String iata){
        Airport airport = repo.findByIata(iata);
        repo.delete(airport);
    }
    public void deleteById(int airport_id){
        repo.deleteById(airport_id);
    }
}
