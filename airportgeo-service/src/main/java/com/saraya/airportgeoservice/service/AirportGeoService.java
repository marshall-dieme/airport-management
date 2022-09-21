package com.saraya.airportgeoservice.service;

import com.saraya.airportgeoservice.bean.Airport;
import com.saraya.airportgeoservice.bean.AirportGeo;
import com.saraya.airportgeoservice.bean.AirportGeoDto;
import com.saraya.airportgeoservice.repo.AirportGeoRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public Optional<AirportGeo> getById(int id){
        return repo.findById(id);
    }

    public AirportGeo create(AirportGeoDto dto){

        return repo.save(toEntity(dto));
    }

    public AirportGeo update(AirportGeo airportGeo){
        return repo.save(airportGeo);
    }

    public void delete(int id){
        repo.deleteById(id);
    }

    public Optional<AirportGeo> getByCountryAndCity(String country, String city) {
        return  repo.findByCountryAndCity(country, city);
    }

    public Airport getAirportByName(String name){
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> urlValues = new HashMap<>();
        urlValues.put("name", name);
        Airport airport = restTemplate.getForEntity("http://localhost:8004/Airport/{name}",
                Airport.class, urlValues).getBody();
       return airport;
    }

    public AirportGeo toEntity(AirportGeoDto dto){
        AirportGeo airportGeo = new AirportGeo();
        airportGeo.setAirportId(dto.getAirportGeoId());
        airportGeo.setAirportId(airportGeo.getAirportId());
        airportGeo.setCity(dto.getCity());
        airportGeo.setCountry(dto.getCountry());
        return airportGeo;
    }
}
