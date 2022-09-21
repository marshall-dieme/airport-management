package com.saraya.airportgeo.service;

import com.saraya.airportgeo.model.AirportGeo;
import com.saraya.airportgeo.repository.AirportGeoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AirportGeoService {

    private final AirportGeoRepository repo;

    public AirportGeoService(AirportGeoRepository repo) {
        this.repo = repo;
    }

    public List<AirportGeo> getAll(){
        return repo.findAll();
    }

    public  AirportGeo getByCountryAndCity(
            String country , String city){
        return repo.findByCountryAndCity(country, city);
    }

    public AirportGeo create (AirportGeo airportGeo){
        return repo.save(airportGeo);
    }

    public AirportGeo update(AirportGeo airportGeo){
        return repo.save(airportGeo);
    }

    public void deleteByCountryAndCity(String country , String city){
        AirportGeo airportGeo = repo.findByCountryAndCity(country , city);
        repo.delete(airportGeo);
    }
    public void deleteById(int airport_geo_id){
        repo.deleteById(airport_geo_id);
    }


    public String getIdAirportGeo(String country) {
        return repo.getIdAirportGeo(country);
    }
}
