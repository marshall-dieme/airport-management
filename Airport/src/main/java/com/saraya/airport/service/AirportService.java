package com.saraya.airport.service;

import com.saraya.airport.model.Airport;
import com.saraya.airport.repository.AirportRepository;
import com.saraya.airport.vo.AirportGeo;
import com.saraya.airport.vo.ResponseTemplateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AirportService {

    @Autowired
    private AirportRepository repo;

    @Autowired
    private RestTemplate restTemplate;


    public Airport save(Airport airport){
        return repo.save(airport);

    }
    public List<Airport> findAll(){
     return repo.findAll();
    }

//    public Airport findById(long airport_id){
//        return repo.findById(airport_id);
//    }
//
    public Airport update(Airport airport){
        return repo.save(airport);
    }

    public void deleteById(long id){
        repo.deleteById(id);
    }

    public ResponseTemplateVo getAirportWithAirportGeo(long airport_id){
        ResponseTemplateVo vo = new ResponseTemplateVo();
        Airport airport = repo.findById(airport_id);

        AirportGeo airportGeo = restTemplate.getForObject("http://localhost:8081/airportGeo/" +
                        airport.getAirport_geo_id(), AirportGeo.class);
        vo.setAirport(airport);
        vo.setAirportGeo(airportGeo);
        return vo;
    }
}
