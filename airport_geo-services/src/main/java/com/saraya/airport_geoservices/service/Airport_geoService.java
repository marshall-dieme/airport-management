package com.saraya.airport_geoservices.service;

import com.saraya.airport_geoservices.model.Airport_geo;
import com.saraya.airport_geoservices.repository.Airport_geoRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class Airport_geoService {

    private final Airport_geoRepo repo;

    public Airport_geoService(Airport_geoRepo repo) {
        this.repo = repo;
    }

    public List<Airport_geo> getAll() {
        return repo.findAll();
    }
    public Optional<Airport_geo> getById(Long id){
        return repo.findById(id);
    }
    public Airport_geo  saveAirport_geo(Airport_geo airport_geo) {
        return repo.save(airport_geo);
    }

    public Airport_geo  updateAirport_geo(Airport_geo airport_geo,Long id) {
       Optional<Airport_geo> up = repo.findById(id);      Airport_geo airport = null;
       if(up.isPresent()){
           airport = up.get();
           airport.setCountry(airport_geo.getCountry());
           airport.setCity(airport_geo.getCity());
           repo.save(airport_geo);
       }
       return airport;
    }

    public Airport_geo getAirport_geoByCountryAndCity(String country,String city){
        return repo.findAirport_geoByCountryAndCity(country, city);
    }

    public void deleteById(Long id) {

        repo.deleteById(id);
    }

}
