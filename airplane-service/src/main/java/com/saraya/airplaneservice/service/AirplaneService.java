package com.saraya.airplaneservice.service;

import com.saraya.airplaneservice.model.Airplane;
import com.saraya.airplaneservice.model.AirplaneDTO;
import com.saraya.airplaneservice.repository.AirplaneRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Airplane create (AirplaneDTO dto){
        Airplane airplane = new Airplane();
        RestTemplate template = new RestTemplate();
        Map<String , String> UrlValues = new HashMap<>();
        UrlValues.put(("airplaneTypeIdentifier") , dto.getAirplaneTypeIdentifier());
        Integer airplaneTypeId = template.getForEntity(
                "http://localhost:8087/airplane-type/{airplaneTypeIdentifier}",
                Integer.class, UrlValues)
                .getBody();
        changeToModel(dto , airplane);
        airplane.setAirplaneTypeId(airplaneTypeId);
        return repo.save(airplane);
    }

    public Airplane update(Airplane dto){
        Airplane airplane = new Airplane();
        airplane.setCapacity(dto.getCapacity());
        airplane.setAirplaneTypeIdentifier(dto.getAirplaneTypeIdentifier());
        return repo.save(airplane);
    }
    public static void changeToModel(AirplaneDTO dto , Airplane airplane){
        airplane.setCapacity(dto.getCapacity());
        airplane.setAirplaneTypeIdentifier(dto.getAirplaneTypeIdentifier());
    }


    public void deleteByCapacity( String capacity){
        Airplane airplane = repo.findByCapacity(capacity);
        repo.delete(airplane);
    }
    public void deleteById(int airplane_id){
        repo.deleteById(airplane_id);
    }


}
