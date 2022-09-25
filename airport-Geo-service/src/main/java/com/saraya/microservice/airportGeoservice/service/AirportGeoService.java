package com.saraya.microservice.airportGeoservice.service;

import com.saraya.microservice.airportGeoservice.model.AirportGeo;
import com.saraya.microservice.airportGeoservice.repo.AirportGeoRepo;

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

    public AirportGeo getById(int id) {
        return repo.findById(id).get();
    }

    public AirportGeo create(AirportGeo arp) {
        return repo.save(arp);
    }

    public AirportGeo update(AirportGeo arp) {
        return repo.save(arp);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    /*public AirportGeo getIdArp(String country) {

        return repo.findByCountry(country);
    }*/
}
