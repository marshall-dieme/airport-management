package com.saraya.microservice.airplaneservice.service;


import com.saraya.microservice.airplaneservice.bean.Airplane;
import com.saraya.microservice.airplaneservice.repo.AirplaneRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirplaneService {

    private final AirplaneRepo repo;





    public AirplaneService(AirplaneRepo repo) {
        this.repo = repo;
    }

    public List<Airplane> getAll(){
        return repo.findAll();
    }

    public Airplane getById(int id) {
        return repo.findById(id).get();
    }

    public Airplane create(Airplane arp) {
        return repo.save(arp);
    }

    public Airplane update(Airplane arp) {
        return repo.save(arp);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    /*public AirportGeo getIdArp(String country) {

        return repo.findByCountry(country);
    }*/


}
