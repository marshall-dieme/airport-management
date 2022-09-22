package com.microservices.airportgeoservices.service;


import com.microservices.airportgeoservices.entity.AirportGeo;
import com.microservices.airportgeoservices.repository.AirportGeoRepo;
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
    public Optional<AirportGeo> getById(Long airport_geo_id) {
        return repo.findById(airport_geo_id);
    }

    public AirportGeo create(AirportGeo airportgeo) {
        return repo.save(airportgeo);
    }

    public AirportGeo update(AirportGeo airportgeo) {
        return repo.save(airportgeo);
    }

    public void delete(Long airport_geo_id) {
        repo.deleteById(airport_geo_id);
    }

    public String getIdGeo(String country, String city) {
        return repo.getById(country, city);
    }
}
