package com.saraya.servicesservice.service;

import com.saraya.servicesservice.model.Services;
import com.saraya.servicesservice.repository.ServiceRepository;
import org.springframework.stereotype.Service;
import java.util.List;

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

    public Services createServices(Services services){

        return repo.save(services);
    }
    public Services updateServices(Services services){
        return repo.save(services);

    }

    public void deleteServices(Long services_id){

        repo.deleteById(services_id);
    }
    public Long getServicesId(String services_name)
    {
        return repo.getIdServices(services_name);
    }
}
