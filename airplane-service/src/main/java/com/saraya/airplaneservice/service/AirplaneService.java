package com.saraya.airplaneservice.service;

import com.saraya.airplaneservice.model.Airplane;
import com.saraya.airplaneservice.repository.AirplaneRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AirplaneService {

    public final AirplaneRepository repo;

    public AirplaneService(AirplaneRepository repo) {
        this.repo = repo;
    }
    public List<Airplane> getAll(){
        return repo.findAll();
    }

    public  Airplane getByCapacity(
            String capacity){
        return repo.findByCapacity(capacity);
    }

    public Airplane create (Airplane airplane){
        return repo.save(airplane);
    }

    public Airplane update(Airplane airplane){
        return repo.save(airplane);
    }

    public void deleteByCapacity( String capacity){
        Airplane airplane = repo.findByCapacity(capacity);
        repo.delete(airplane);
    }
    public void deleteById(int airplane_id){
        repo.deleteById(airplane_id);
    }


}
