package com.saraya.Airport_Geoservice.service;

import com.saraya.Airport_Geoservice.model.Airport_Geo;
import com.saraya.Airport_Geoservice.repository.Airport_GeoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Airport_GeoService {
    private final Airport_GeoRepository repo;

    public Airport_GeoService(Airport_GeoRepository repo) {
        this.repo = repo;
    }
    public List<Airport_Geo> getAllAirport_GeoServices() {
        return repo.findAll();
    }
    public Airport_Geo getById(Long id) {
        return (Airport_Geo) repo.findById(id).get();
    }
    public Airport_Geo create(Airport_Geo airport_Geo) {
        return repo.save(airport_Geo);
    }
    public Airport_Geo update(Airport_Geo airport_Geo){
        return repo.save(airport_Geo);
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
