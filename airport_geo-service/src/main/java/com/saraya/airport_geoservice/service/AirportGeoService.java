package com.saraya.airport_geoservice.service;

import com.saraya.airport_geoservice.model.AirportGeo;
import com.saraya.airport_geoservice.repo.AirportGeorRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportGeoService {

    private final AirportGeorRepo repo;

    public AirportGeoService(AirportGeorRepo repo) {
        this.repo = repo;
    }


    public AirportGeo saveAirport(AirportGeo airportGeo) {
        return repo.save(airportGeo);
    }

    public List<AirportGeo> getAllAirport() {
        return repo.findAll();
    }
    public Optional<AirportGeo> getById(Long airport_geo_id){
        return repo.findById(airport_geo_id);
    }
    public AirportGeo getByCountryAndCity(String country, String city){
       return repo.findByCountryAndCity(country, city);
    }

    public AirportGeo update(AirportGeo airportGeo) {
        return repo.save(airportGeo);
    }
    public void delete(Long airport_geo_id){
         repo.deleteById(airport_geo_id);

    }



}
