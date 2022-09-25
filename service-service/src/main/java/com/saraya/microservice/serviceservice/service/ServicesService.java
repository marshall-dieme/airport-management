package com.saraya.microservice.serviceservice.service;


import com.saraya.microservice.serviceservice.bean.Services;
import com.saraya.microservice.serviceservice.repo.ServiceRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesService {

    private final ServiceRepo repo;





    public ServicesService(ServiceRepo repo) {
        this.repo = repo;
    }

    public List<Services> getAll(){
        return repo.findAll();
    }

    public Services getById(int id) {
        return repo.findById(id).get();
    }

    public Services create(Services arp) {
        return repo.save(arp);
    }

    public Services update(Services arp) {
        return repo.save(arp);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    /*public AirportGeo getIdArp(String country) {

        return repo.findByCountry(country);
    }*/


}
