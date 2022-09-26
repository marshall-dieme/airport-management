package com.spring.serviceservice.service;


import com.spring.serviceservice.DTO.ServicesDto;
import com.spring.serviceservice.bean.Services;
import com.spring.serviceservice.repository.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.apache.coyote.http11.Constants.a;

@Service
public class ServicesServices {
    @Autowired
    private ServiceRepo repo;

    //<Retreive all Service>
    public List<Services> getAll(){
        return repo.findAll();
    }

    // retreive one Service by id
    public Optional<Services> getById(int id){
        return repo.findById(id);
    }

    String urlAirport ="http://localhost:8200/airports/airportName/{airportName}";
    //<Add new Service>
    public Services create(ServicesDto dto){

        Services services = new Services();
        RestTemplate template = new RestTemplate();
        Map<String , String> urlvalues = new HashMap<>();
        urlvalues.put("airportName", dto.getAirportName());
        int airportId = template.getForEntity(
                urlAirport,
                Integer.class,
                urlvalues).getBody();
        services.setId(dto.getId());
        changeToModel(services,dto);
        services.setAirportId(airportId);
        return repo.save(services);
    }

    public List<Services> getServicebyAirport(String airportName){
        Map<String, String> values = new HashMap<>();
        values.put("airportName",airportName);
        RestTemplate template = new RestTemplate();
        int airportId= template.getForEntity(
                urlAirport,
                Integer.class,
                values).getBody();
        return repo.findByAirportId(airportId);
    }

    public Services update(Services services){
        return repo.save(services);
    }

    public void delete(int id){
        repo.deleteById(id);
    }

    public void changeToModel(Services services, ServicesDto dto){
        services.setName(dto.getName());
    }

    public String getServiceId(String name){
        return repo.findByName(name);
    }
}
