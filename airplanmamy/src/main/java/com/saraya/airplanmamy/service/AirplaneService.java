package com.saraya.airplanmamy.service;

import com.saraya.airplanmamy.bean.Airplane;
import com.saraya.airplanmamy.repository.AirplaneRepo;
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
    public Airplane create(Airplane airplane){
        return repo.save(airplane);
    }
    public Airplane update(Airplane airplane){

        return repo.save(airplane);
    }
    public void delete (int id){
        repo.deleteById(id);
    }
}
