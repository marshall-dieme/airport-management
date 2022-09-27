package com.saraya.airplaneservice.service;

import com.saraya.airplaneservice.model.Airplane;
import com.saraya.airplaneservice.repository.AirplaneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirplaneService {
    private final AirplaneRepository repo;

    public AirplaneService(AirplaneRepository repo) {
        this.repo = repo;
    }

    public List<Airplane> getAllAirplane(){
        return repo.findAll();
    }

    public Airplane GetByIdAirplane(Long airplane_id){
        return repo.findById(airplane_id).orElse(null);
    }

    public Airplane createAirplane(Airplane airplane){
        return repo.save(airplane);
    }

    public Airplane updateAirplane(Airplane airplane){
        return repo.save(airplane);
    }


    public void deleteAirplane(Long airplane_id){
        repo.deleteById(airplane_id);
    }
}
