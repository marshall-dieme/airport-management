package com.saraya.servicessevice.service;

import com.saraya.servicessevice.bean.ServiceDto;
import com.saraya.servicessevice.bean.Services;
import com.saraya.servicessevice.repo.ServiceRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServiceService {

    private final ServiceRepo repo;

    public ServiceService(ServiceRepo repo) {
        this.repo = repo;
    }

    public int getIdServiceByName(String name){
        return repo.findByName(name).getServiceId();
    }

    public Services creat(ServiceDto dto){

        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> urlValues = new HashMap<>();
        urlValues.put("airportName", dto.getAirportName());

        int airportId = restTemplate.getForEntity("http://localhost:8004/Airport/{airportName}",
                Integer.class, urlValues).getBody();
        dto.setAirportId(airportId);

        return repo.save(toEntity(dto));
    }

    public List<Services> getAll(){
        return repo.findAll();
    }

    public Services toEntity(ServiceDto dto){
        Services service = new Services();
        service.setServiceId(dto.getServiceId());
        service.setName(dto.getName());
        service.setAirportId(dto.getAirportId());
        return service;
    }
}
