package com.saraya.servicesservice.service;

import com.saraya.servicesservice.model.Services;
import com.saraya.servicesservice.model.ServicesDto;
import com.saraya.servicesservice.repos.ServicesRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServicesService {

    private final ServicesRepo repo;

    public ServicesService(ServicesRepo repo) {
        this.repo = repo;
    }

    public List<Services> getAll(){
        return repo.findAll();

    }

    /*public Services getByName(String name) {
        return repo.findByName(name);

    }*/

    public Long getIdServices(String serviceName) {
        return repo.getServiceId(serviceName);
    }



    public Services create(ServicesDto dto){
        Services services = new Services();
        RestTemplate template = new RestTemplate();
        Map<String, String> value = new HashMap<>();
        value.put("airport_name", dto.getAirport_name());

        Long idAirport = template.getForEntity("http://localhost:8200/airports/airportName/{airport_name}",
                Long.class, value).getBody();

        changeToModel(dto, services);
        services.setIdAirport(idAirport);
        return repo.save(services);
    }




    public Services update(ServicesDto dto){
        Services services = new Services();
        services.setServiceId(dto.getServiceId());
        changeToModel(dto, services);
        return repo.save(services);
    }



    public List <Services> getServicesByAirport(String airportName) {
        Map<String, String> values = new HashMap<>();
        values.put("airport_name", airportName);

        RestTemplate template = new RestTemplate();
        Long idAirport = template.getForEntity("http://localhost:8200/airports/airportName/{airport_name}",
                Long.class, values).getBody();

        return repo.findByIdAirport(idAirport);
    }

    private static void changeToModel(ServicesDto dto, Services services) {
        services.setServiceName(dto.getServiceName());


    }



    public void delete(Long id ){
        repo.deleteById(id);
    }
}
