package com.saraya.Airplaneservice.service;

import com.saraya.Airplaneservice.model.Airplane;
import com.saraya.Airplaneservice.repository.AirplaneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AirplaneService {

    private final AirplaneRepository repository;

    public List<Airplane> getAllAirplanes() {
        return repository.findAll();
    }

    public Airplane getAirplane(Long airplane_id) {
        return repository.findById(airplane_id).orElse(new Airplane());
    }

    public Airplane getAirplaneByCapacity(int capacity) {
        return repository.findAirplaneByCapacity(capacity);
    }

    public Airplane saveAirplane(Airplane airplane){
        return repository.save(airplane);
    }

    public Airplane updateAirplane(Airplane airplane){
        return repository.save(airplane);
    }

    public void deleteAirplane(Long airplane_id){
        repository.deleteById(airplane_id);
    }
}
