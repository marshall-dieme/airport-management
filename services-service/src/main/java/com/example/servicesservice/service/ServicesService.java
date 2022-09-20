package com.example.servicesservice.service;

import com.example.servicesservice.model.Services;
import com.example.servicesservice.repos.ServicesRepo;
import org.springframework.stereotype.Service;

import java.util.List;

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


    public Services create(Services services){
        return repo.save(services);
    }

    public Services update(Services services){
        return repo.save(services);
    }




    public void delete(Long id ){
        repo.deleteById(id);
    }
}
