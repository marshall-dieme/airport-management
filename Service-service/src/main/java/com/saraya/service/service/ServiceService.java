package com.saraya.service.service;

import com.saraya.service.bean.Service;
import com.saraya.service.repository.ServiceRepo;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService {
    private final ServiceRepo repo;

    public ServiceService(ServiceRepo repo) {
        this.repo = repo;
    }


    public List<Service> getAll(){
        return repo.findAll();
    }


    public Service create(Service service){
        return repo.save(service);
    }

    public Service update(Service service){
       return repo.save(service);
    }


    public void delete(int id){
        repo.deleteById(id);
    }

}
