package com.saraya.microservice.airplane_typeservice.service;



import com.saraya.microservice.airplane_typeservice.bean.AirplaneType;
import com.saraya.microservice.airplane_typeservice.repo.AirplaneTypeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirplaneTypeService {

    private final AirplaneTypeRepo repo;





    public AirplaneTypeService(AirplaneTypeRepo repo) {
        this.repo = repo;
    }

    public List<AirplaneType> getAll(){
        return repo.findAll();
    }

    public AirplaneType getById(int id) {
        return repo.findById(id).get();
    }

    public AirplaneType create(AirplaneType arp) {
        return repo.save(arp);
    }

    public AirplaneType update(AirplaneType arp) {
        return repo.save(arp);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    /*public AirportGeo getIdArp(String country) {

        return repo.findByCountry(country);
    }*/


}
