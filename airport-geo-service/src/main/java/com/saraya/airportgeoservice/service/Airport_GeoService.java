package com.saraya.airportgeoservice.service;


import com.saraya.airportgeoservice.model.Airport_Geo;
import com.saraya.airportgeoservice.repository.Airport_GeoRepository;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class Airport_GeoService {


    private final Airport_GeoRepository repository;

    public Airport_GeoService(Airport_GeoRepository repository) {
        this.repository = repository;
    }

    public List<Airport_Geo> getAll(){
        return repository.findAll();
    }
    public Airport_Geo getById(Long geo_id){
        return repository.findById(geo_id).get();

    }
    public Airport_Geo create(Airport_Geo airport_geo){
        return repository.save(airport_geo);

    }

    public Airport_Geo update(Airport_Geo airport_geo){

        return repository.save(airport_geo);
    }


    public void delete(Long geo_id){
        repository.deleteById(geo_id);
    }

    public Airport_Geo getIdAirport_Geo(String country, String city) {
        return repository.findAirport_GeoByCountryAndCity(country,city);

    }

}
