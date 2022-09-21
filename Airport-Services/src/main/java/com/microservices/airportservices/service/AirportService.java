package com.microservices.airportservices.service;


import com.microservices.airportservices.entity.Airport;
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

    public Airport create(Airport airport) {
        Airport airport1 = new Airport();
        RestTemplate template = new RestTemplate();
        Map<String, String> urlValues = new HashMap<>();
        urlValues.put("servicesName", airport.getIdServices());
        String idServices  = template.getForEntity(
                        "http://localhost:8002/servicesName/{servicesName}",
                        String.class,
                        urlValues)
                .getBody();
        airport1.setIdServices(idServices);
        return repo.save(airport1);
    }

    public Airport update(Airport airport) {
        return repo.save(airport);
    }

    public void delete(Long airport_id) {
        repo.deleteById(airport_id);
    }

}
