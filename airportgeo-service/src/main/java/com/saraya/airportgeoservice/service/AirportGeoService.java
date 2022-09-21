package com.saraya.airportgeoservice.service;

import com.saraya.airportgeoservice.bean.AirportGeo;
import com.saraya.airportgeoservice.repo.AirportGeoRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportGeoService {

    private final AirportGeoRepo repo;

    public AirportGeoService(AirportGeoRepo repo) {
        this.repo = repo;
    }

    public List<AirportGeo> getAll(){
        return repo.findAll();
    }

    public Optional<AirportGeo> getById(String id){
        return repo.findById(id);
    }

    public AirportGeo create(AirportGeo airportGeo){
        airportGeo.generateId();
        return repo.save(airportGeo);
    }

    public AirportGeo update(AirportGeo airportGeo){
        return repo.save(airportGeo);
    }

    public void delete(String id){
        repo.deleteById(id);
    }
}
