package com.microservices.airportservices.service;


import com.microservices.airportservices.entity.Airport;
import com.microservices.airportservices.entity.AirportDTO;
import com.microservices.airportservices.repository.AirportRepo;
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

    public Optional<Airport> getById(Long airport_id) {
        return repo.findById(airport_id);
    }

    public Airport create(AirportDTO dto) {
        Airport airport = new Airport();
        RestTemplate template = new RestTemplate();
        Map<String, String> urlValues = new HashMap<>();
        urlValues.put("country", dto.getCountry());
        urlValues.put("city", dto.getCity());
        String idAiportGeo = template.getForEntity(
                        "http://localhost:8000/airports/country/city/{country}/{city}",
                        String.class,
                        urlValues)
                .getBody();
        changeToModel(dto, airport);
        airport.setIdGeo(idAiportGeo);
        return repo.save(airport);
    }

    public Airport update(AirportDTO dto) {
        Airport airport = new Airport();
        airport.setAirport_id(dto.getAirport_id());
        changeToModel(dto, airport);
        return repo.save(airport);
    }

    private static void changeToModel(AirportDTO dto, Airport airport) {
        airport.setIata(dto.getIata());
        airport.setIcao(dto.getIcao());
        airport.setAirportName(dto.getAirportName());
    }

    public void delete(Long airport_id) {
        repo.deleteById(airport_id);
    }

    public Airport findAirportByAirportGeo(String country, String city){
        RestTemplate template = new RestTemplate();
        Map<String, String> urlValues = new HashMap<>();
        urlValues.put("country", country);
        urlValues.put("city", city);
        String idAiportGeo = template.getForEntity(
                        "http://localhost:8000/airports/country/city/{country}/{city}",
                        String.class,
                        urlValues)
                .getBody();

        return repo.findByIdGeo(idAiportGeo);
    }

}
