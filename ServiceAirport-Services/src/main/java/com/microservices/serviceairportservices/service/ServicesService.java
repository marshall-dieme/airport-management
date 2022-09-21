package com.microservices.serviceairportservices.service;

import com.microservices.serviceairportservices.entity.Service;
import com.microservices.serviceairportservices.repository.ServiceRepo;

import java.util.List;
import java.util.Optional;

public class ServicesService {

    private final ServiceRepo repo;

    public ServicesService(ServiceRepo repo) {
        this.repo = repo;
    }

    public List<Service> getAll(){
        return repo.findAll();
    }

    public Optional<Service> getById(String servicesId) {
        return repo.findById(servicesId);
    }

    public Service create(Service service) {

        return repo.save(service);
    }

    public Service update(Service service) {
        return repo.save(service);
    }

    public void delete(String servicesId) {
        repo.deleteById(servicesId);
    }

    public String getidServices(String servicesName) {
        return repo.getidServices(servicesName);
    }


}

