package com.saraya.servicesservice.service;

import com.saraya.servicesservice.model.Services;
import com.saraya.servicesservice.repos.Service_Repo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ServiceServices {

    private final Service_Repo repo;

    public ServiceServices(Service_Repo repo) {
        this.repo = repo;
    }


    public List<Services> getAll(){ return  repo.findAll();}

    public Services getById(Long services_id){
        return repo.findById(services_id).get();
    }


    public Services create(Services serv){ return  repo.save(serv);}

    public Services update(Services serv){ return  repo.save (serv);}


    public void deleteByName(Long services_id) {
        repo.deleteById(services_id);
    }
    public void delete(Long services_id){
        repo.deleteById(services_id);
    }
}
