package com.saraya.airportgeoservice.services;

import com.saraya.airportgeoservice.model.AirportGeo;
import com.saraya.airportgeoservice.repos.AirportGeoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportGeoService {

    private final AirportGeoRepo repo;

    public AirportGeoService(AirportGeoRepo repo) {
        this.repo = repo;
    }

    public List<AirportGeo> getAll(){
        return repo.findAll();

    }

    public AirportGeo getByCityAndCountry(String city, String country) {
        return repo.findByCityAndCountry(city,country);

    }


    public AirportGeo create(AirportGeo airportGeo){
        return repo.save(airportGeo);
    }

    public AirportGeo update(AirportGeo airportGeo){
        return repo.save(airportGeo);
    }

    public void deleteByCityAndCountry(String city,String country){
        AirportGeo airportGeo = repo.findByCityAndCountry(city,country);
        repo.delete(airportGeo);

    }

    public void delete(Long id ){
        repo.deleteById(id);
    }
}
