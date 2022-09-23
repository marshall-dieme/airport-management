package com.saraya.servicesservice.service;

import com.saraya.servicesservice.model.Services;
import com.saraya.servicesservice.model.ServicesDTO;
import com.saraya.servicesservice.repository.ServicesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ServicesService {

    @Autowired
    private ModelMapper mapper;

    private final ServicesRepository repo;

    public ServicesService(ServicesRepository repo) {
        this.repo = repo;
    }

    public List<Services> getAll(){
        return repo.findAll();
    }

    public Services getByServicesName(String servicesName){
        return repo.findByServicesName(servicesName);
    }

    public Services create (ServicesDTO dto){
        Services services = mapper.map(dto , Services.class);
        RestTemplate template = new RestTemplate();
        Map<String , String> UrlValues = new HashMap<>();
        UrlValues.put(("airportName"), dto.getAirportName());
        Integer airportId = template.getForEntity(
                        "http://localhost:8083/airport/airportName/{airportName}",
                        Integer.class, UrlValues)
                .getBody();
       // changeToModel(dto, services);
        services.setAirportId(airportId);
        return repo.save(services);
    }

    public Services update(ServicesDTO dto){
        Services services = new Services();
        services.setServiceId(dto.getServiceId());
        return repo.save(services);
    }

    public void deleteByServicesName(String servicesName){
        Services services = repo.findByServicesName(servicesName);
        repo.delete(services);
    }
    public void deleteById(int service_id){
        repo.deleteById(service_id);
    }
}
