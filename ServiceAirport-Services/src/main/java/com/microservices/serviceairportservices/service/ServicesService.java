package com.microservices.serviceairportservices.service;

import com.microservices.serviceairportservices.entity.Services;
import com.microservices.serviceairportservices.entity.ServiceDTO;
import com.microservices.serviceairportservices.repository.ServiceRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ServicesService {

    private final ServiceRepo repo;

    public ServicesService(ServiceRepo repo) {
        this.repo = repo;
    }

    public List<Services> getAll(){
        return repo.findAll();
    }

    public Optional<Services> getById(Long servicesId) {
        return repo.findById(servicesId);
    }

    public Services create(ServiceDTO dto) {
        Services service = new Services();
        RestTemplate template = new RestTemplate();
        Map<String, String> urlValues = new HashMap<>();
        urlValues.put("airportName", dto.getAirportName());
        String idAirport = template.getForEntity(
                        "http://localhost:8001/airp/airportName/{airportName}",
                        String.class,
                        urlValues)
                .getBody();
        changeToModel(dto, service);
        service.setIdAirport(idAirport);
        return repo.save(service);
    }

    public Services update(ServiceDTO dto) {
        Services service = new Services();
        service.setServicesId(dto.getServicesId());
        changeToModel(dto, service);
        return repo.save(service);
    }

    private static void changeToModel(ServiceDTO dto, Services service) {
        service.setServicesName(dto.getServicesName());

    }

    public void delete(Long servicesId) {
        repo.deleteById(servicesId);
    }

    public Services findAirportByService(String airportName){
        RestTemplate template = new RestTemplate();
        Map<String, String> urlValues = new HashMap<>();
        urlValues.put("airportName", airportName);
        String idAirport = template.getForEntity(
                        "http://localhost:8001/airp/airportName/{airportName}",
                        String.class,
                        urlValues)
                .getBody();

        return repo.findByIdAirport(idAirport);
    }

}

