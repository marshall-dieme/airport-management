package com.saraya.airportservice.service;

import com.saraya.airportservice.bean.Airport;
import com.saraya.airportservice.bean.AirportDto;
import com.saraya.airportservice.bean.AirportGeo;
import com.saraya.airportservice.repo.AirportRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AirportService {

    private final AirportRepo repo;

    public AirportService(AirportRepo repo) {
        this.repo = repo;
    }

    public List<Airport> getAll(){
        return repo.findAll();
    }

    public Optional<Airport> getByName(String name){
        return repo.findByName(name);
    }

    public Airport create(AirportDto dto){

        Airport airport = toEntity(dto);
        airport.setAirportGeoId(getAirportGeo(dto).getAirportGeoId());
        dto.setAirportGeoId(airport.getAirportGeoId());

        return repo.save(toEntity(dto));
    }

    public AirportGeo getAirportGeo(AirportDto dto){

        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> urlValues = new HashMap<>();
        urlValues.put("country", dto.getCountry());
        urlValues.put("city", dto.getCity());

        AirportGeo airportGeo = restTemplate.getForEntity("http://localhost:8005/AirportGeo/{country}/{city}",
                AirportGeo.class, urlValues).getBody();

        return airportGeo;
    }

    public AirportGeo getAirportGeo(String country, String city){

        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> urlValues = new HashMap<>();
        urlValues.put("country", country);
        urlValues.put("city", city);

        AirportGeo airportGeo = restTemplate.getForEntity("http://localhost:8005/AirportGeo/{country}/{city}",
                AirportGeo.class, urlValues).getBody();

        return airportGeo;
    }

    public AirportDto update(AirportDto dto){
       repo.save(toEntity(dto));
       return dto;
    }

    public void delete(int id){
        repo.deleteById(id);
    }

    public Airport toEntity(AirportDto dto){
        Airport airport = new Airport();
        airport.setAirportId(dto.getAirportId());
        airport.setIata(dto.isIata());
        airport.setIcao(dto.isIcao());
        airport.setAirportGeoId(dto.getAirportGeoId());
        airport.setName(dto.getName());
        return airport;
    }

}
