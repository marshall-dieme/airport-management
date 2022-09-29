package com.saraya.servicesservice.service;

import com.saraya.servicesservice.model.ServiceDto;
import com.saraya.servicesservice.model.Services;
import com.saraya.servicesservice.repository.ServiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServicesService {

    private final ServiceRepository repo;

    public ServicesService(ServiceRepository repo) {
        this.repo = repo;
    }

    public List<Services> getAllServices(){
        return repo.findAll();
    }

    public Services getByIdServices(Long services_id){

        return repo.findById(services_id).orElse(null);
    }

    public Services createServices(ServiceDto dto){
        Services services = new Services();
        services.setServices_id(dto.getServices_id());
        changeToModel(dto, services);

        getRelation(dto, services);

        return repo.save(services);
    }
    public Services updateServices(ServiceDto dto){
        Services services=new Services();
        changeToModel(dto, services);

        getRelation(dto, services);

        return repo.save(services);

    }

    private void getRelation(ServiceDto dto, Services services) {
        RestTemplate template = new RestTemplate();
        Map<String, String> UrlValues= new HashMap<>();
        UrlValues.put("airport_name", dto.getAirport_name());
        Long airport_id = template.getForEntity("http://localhost:8081/airport/airport_name/{airport_name}",
                Long.class, UrlValues)
                .getBody();
        changeToModel(dto, services);
        services.setAirport_id(airport_id);
    }
    private void changeToModel(ServiceDto dto, Services services) {
        services.setServices_name(dto.getServices_name());
    }

    public void deleteServices(Long services_id){

        repo.deleteById(services_id);
    }
    public Long getServicesId(String services_name)
    {
        return repo.getIdServices(services_name);
    }
}
