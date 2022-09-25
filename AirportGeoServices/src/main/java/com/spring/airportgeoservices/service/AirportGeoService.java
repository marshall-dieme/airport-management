package com.spring.airportgeoservices.service;


import com.spring.airportgeoservices.bean.AirportGeo;
import com.spring.airportgeoservices.repo.AirportGeoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AirportGeoService {

    @Autowired
    private AirportGeoRepo repo;

    public List<AirportGeo> getAll(){
        return repo.findAll();
    }

    public Optional<AirportGeo>getById(String id){
        return repo.findById(id);
    }
    public AirportGeo create(AirportGeo airportGeo){
        airportGeo.generateId();
        return repo.save(airportGeo);
    }



   /* public AirportGeoDto create(AirportGeoDto airportGeoDto){
        AirportGeo airportGeo = mapper.toEntity(airportGeoDto);
        repo.save(airportGeo);
        return mapper.toDto(airportGeo);
    }
*/

    public AirportGeo update(AirportGeo airportGeo){
        return repo.save(airportGeo);
    }
    
   /* public AirportGeoDto update(AirportGeoDto airportGeoDto){
        AirportGeo airportGeo = mapper.toEntity(airportGeoDto);
        repo.save(airportGeo);
        return mapper.toDto(airportGeo);
        *//*AirportGeo airportGeo1 = repo.findByAirportGeoId(id);
        airportGeo1.setCountry(airportGeo.getCountry());
        airportGeo1.setCity(airportGeo.getCity());
        return repo.save(airportGeo1);*//*
    }*/

    public void delete(String id){
        repo.deleteById(id);
    }

    public String getAirportGeoId(String city, String country){
        return repo.findByCityAndCountry(city, country).getAirportGeoId();
    }

    /*public Optional<AirportGeo> getByCityAndCountry(String country , String city){
        return repo.findByCityAndCountry(city,country);
    }*/


}
