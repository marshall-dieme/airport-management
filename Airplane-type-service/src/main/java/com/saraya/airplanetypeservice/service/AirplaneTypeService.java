package com.saraya.airplanetypeservice.service;

import com.saraya.airplanetypeservice.model.AirplaneType;
import com.saraya.airplanetypeservice.repository.AirplaneTypeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AirplaneTypeService {

    private final AirplaneTypeRepository repo;

    public AirplaneTypeService(AirplaneTypeRepository repo) {
        this.repo = repo;
    }

    public List<AirplaneType> getAll(){
        return repo.findAll();
    }

    public  AirplaneType getByAirplaneTypeIdentifier(
            String airplaneTypeIdentifier){
        return repo.findByAirplaneTypeIdentifier(airplaneTypeIdentifier);
    }


    public AirplaneType create (AirplaneType airplaneType){
        return repo.save(airplaneType);
    }

    public AirplaneType update(AirplaneType airplaneType){
        return repo.save(airplaneType);
    }

    public void deleteByAirplaneTypeIdentifier(
            String airplaneTypeIdentifier){
        AirplaneType airplaneType = repo.findByAirplaneTypeIdentifier(airplaneTypeIdentifier);
        repo.delete(airplaneType);
    }

    public void deleteById(int airplaneTypeId){
        repo.deleteById(airplaneTypeId);
    }

    public AirplaneType findByAirplaneTypeIdentifier(String airplaneTypeIdentifier) {
        return repo.findByAirplaneTypeIdentifier(airplaneTypeIdentifier);
    }

}
