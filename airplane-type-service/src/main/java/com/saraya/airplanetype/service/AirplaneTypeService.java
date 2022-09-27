package com.saraya.airplanetype.service;

import com.saraya.airplanetype.model.AirplaneType;
import com.saraya.airplanetype.repository.AirplaneTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirplaneTypeService {

    private final AirplaneTypeRepository repo;

    public AirplaneTypeService(AirplaneTypeRepository repo) {
        this.repo = repo;
    }

    public List<AirplaneType> getAllAirplaneType() {
        return repo.findAll();
    }

    public AirplaneType getByIdAirplaneType(Long airplane_type_id){
        return repo.findById(airplane_type_id).orElse(null);
    }

    public AirplaneType createAirplaneType(AirplaneType airplaneType) {
        return repo.save(airplaneType);
    }


    public AirplaneType updateAirplaneType(AirplaneType airplaneType){
        return repo.save(airplaneType);
    }

    public void deleteAirplaneType(Long airplane_type_id) {
        repo.deleteById(airplane_type_id);
    }
}
