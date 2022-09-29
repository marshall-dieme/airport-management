package com.saraya.airplane.service;

import com.saraya.airplane.model.Airplane;
import com.saraya.airplane.repo.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AirplaneService {

    @Autowired
    private AirplaneRepository repository;

    public Airplane create(Airplane airplane){
        return repository.save(airplane);
    }

    public Airplane findAirplaneById(long airplane_id){
        return repository.findById(airplane_id);
    }

    public List<Airplane> findAll(){
        return repository.findAll();
    }

    public Airplane update(Airplane airplane){
        return repository.save(airplane);
    }

    public void deleteById(long airplane_id){
        repository.deleteById(airplane_id);
    }


}
