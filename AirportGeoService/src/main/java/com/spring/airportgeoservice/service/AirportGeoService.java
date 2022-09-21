package com.spring.airportgeoservice.service;

import com.spring.airportgeoservice.bean.AirportGeo;
import com.spring.airportgeoservice.repo.AirportGeoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AirportGeoService {

    @Autowired
    private AirportGeoRepo airportGeoRepo;

    public List<AirportGeo> getAll(){
        return airportGeoRepo.findAll();
    }

    public  AirportGeo create(AirportGeo airportGeo){
        return airportGeoRepo.save(airportGeo);
    }

    public AirportGeo update(int id, AirportGeo airportGeo){
        AirportGeo airportGeo1 = airportGeoRepo.findByAirportGeoId(id);
        airportGeo1.setCountry(airportGeo.getCountry());
        airportGeo1.setCity(airportGeo.getCity());
        return airportGeoRepo.save(airportGeo1);
    }

    public void delete(int id){
        airportGeoRepo.deleteById(id);
    }

}
