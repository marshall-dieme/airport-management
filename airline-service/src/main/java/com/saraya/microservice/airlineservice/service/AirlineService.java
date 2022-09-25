package com.saraya.microservice.airlineservice.service;

import com.saraya.microservice.airlineservice.bean.Airline;
import com.saraya.microservice.airlineservice.repo.AirlineRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineService {

    private final AirlineRepo repo;





    public AirlineService(AirlineRepo repo) {
        this.repo = repo;
    }

    public List<Airline> getAll(){
        return repo.findAll();
    }

    public Airline getById(int id) {
        return repo.findById(id).get();
    }

    public Airline create(Airline arp) {
        return repo.save(arp);
    }

    public Airline update(Airline arp) {
        return repo.save(arp);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    /*public AirportGeo getIdArp(String country) {

        return repo.findByCountry(country);
    }*/


}
