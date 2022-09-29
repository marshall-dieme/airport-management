package com.saraya.microservice.airportGeoservice.service;

import com.saraya.microservice.airportGeoservice.model.AirportGeo;
import com.saraya.microservice.airportGeoservice.repo.AirportGeoRepo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    public AirportGeo getById(Integer airport_geo_id) {
        return repo.findById(airport_geo_id).get();
    }

    public AirportGeo create(AirportGeo arp) {
        return repo.save(arp);
    }

    public AirportGeo update(AirportGeo arp) {
        return repo.save(arp);
    }

    public void delete(Integer airport_geo_id) {
        repo.deleteById(airport_geo_id);
    }

    public Integer getIdAirportGeo(String country,String city) {

        return repo.getIdAirportGeo(country,city);
    }



    /*public AirportGeo getIdArp(String country) {

        return repo.findByCountry(country);
    }*/
}
