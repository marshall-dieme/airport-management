package com.saraya.airportgeo.service;

import com.saraya.airportgeo.model.AirportGeo;
import com.saraya.airportgeo.repo.AirportGeoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportGeoService<AirportGeoRepo> {

    private final AirportGeoRepository repo;

    public AirportGeoService(AirportGeoRepository repo) {
        this.repo = repo;
    }

    public List<AirportGeo> getAll() {
        return repo.findAll();
    }/*
    public AirportGeo GetByCityAndCountry(String city, String country){
        return repo.findByCityAndCountry(city, country);
    }
    public Long getIdAirportGeo(String city, String country){
        return repo.getIdAirportGeo(city, country);
    }*/

    public AirportGeo create(AirportGeo airportGeo) {
        return repo.save(airportGeo);
    }

    public AirportGeo update(AirportGeo airportGeo) {
        return repo.save(airportGeo);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Long getIdAirportGeo(String city, String country) {

        return repo.getIdAirportGeoByCityAndCountry(city, country);
    }

    public void deleteByCityAndCountry(String city, String country) {

        repo.deleteByCityAndCountry(city, country);
    }

   /* public Long getIdAirportGeo(String city, String country) {
         return service.getIdAirportGeo(city, country);
    }*/
}
