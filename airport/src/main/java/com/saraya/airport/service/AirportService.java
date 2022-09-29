package com.saraya.airport.service;

import com.saraya.airport.model.Airport;
import com.saraya.airport.repo.AirportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService<AirportRepo> {
    private final AirportRepository repo;

    public AirportService(AirportRepository repo) {
        this.repo = repo;
    }
    public List<Airport> getAll(){
        return repo.findAll();
    }
    public Airport create(Airport airport){
        return repo.save(airport);
    }
      public Airport update(Airport airport){
        return repo.save(airport);
      }
      public void delete(Long id){
        repo.deleteById(id);
      }
      public Long getIdAirport( String iata,String icao, String name){
        return repo.getIdAirportiataandicaoandname(iata, icao, name);
      }
      public void deleteByiataandicaoandname(String iata,String icao, String name){
        repo.deleteByiataandicaoandname(iata, icao, name);
      }

     }





