package com.saraya.servicesservice.service;

import com.saraya.servicesservice.model.Services;
import com.saraya.servicesservice.repository.ServicesRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ServicesService {

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

    public Services create (Services services){
        return repo.save(services);
    }

    public Services update(Services services){
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
