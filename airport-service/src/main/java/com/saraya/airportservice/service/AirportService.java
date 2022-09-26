package com.saraya.airportservice.service;

import com.saraya.airportservice.model.Airport;
import com.saraya.airportservice.repo.AirportRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {
    private final AirportRepo repo;

    public AirportService(AirportRepo repo) {
        this.repo = repo;
    }

    public Airport saveAirport(Airport airport) {
        return repo.save(airport);
    }

//    public List<AirportGeo> getAirport() {
//        return repo.findAll();
//    }
    public Airport getByCountryAndCity(String iata, String icao, String airport_name){
        return repo.findByCountryAndCity(iata, icao, airport_name);
    }

    public Long delete(Long airport_id){
        repo.deleteById(airport_id);
        return airport_id;
    }
}
