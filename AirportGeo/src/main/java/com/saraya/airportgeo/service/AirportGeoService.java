package com.saraya.airportgeo.service;

import com.saraya.airportgeo.model.AirportGeo;
import com.saraya.airportgeo.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportGeoService {

    @Autowired
    private AirportRepository airportRepository;


    public AirportGeo save(AirportGeo airportGeo){
        return airportRepository.save(airportGeo);
    }

//    public AirportGeo findById(long airport_geo_id) {
//        return airportRepository.findById(airport_geo_id);
//    }

    public AirportGeo findById(long id){
        return airportRepository.findById(id);
    }

    public List<AirportGeo> findAll() {
        return airportRepository.findAll();
    }

    public AirportGeo update(AirportGeo airportGeo){
        return airportRepository.save(airportGeo);
    }

//    public AirportGeo update(AirportGeo airportGeo){
//        AirportGeo existingAirportGeo = airportRepository.findById(airportGeo.getAirport_geo_id());
//        existingAirportGeo.setCountry(airportGeo.getCountry());
//        existingAirportGeo.setCity(airportGeo.getCity());
//        return airportRepository.save(existingAirportGeo);
//    }

    public void deleteById(long airport_geo_id){
        airportRepository.deleteById(airport_geo_id);
    }

//        public String deleteById(long id){
//            airportRepository.deleteById(id);
//       return ""+id ;
   }
