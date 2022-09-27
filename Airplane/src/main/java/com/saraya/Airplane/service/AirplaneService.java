package com.saraya.Airplane.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.saraya.Airplane.dto.AirplaneToAirline;
import com.saraya.Airplane.dto.AirplaneToAirplaneType;
import com.saraya.Airplane.dto.AirplaneToFlight;
import com.saraya.Airplane.entity.Airplane;
import com.saraya.Airplane.repository.AirplaneRepo;

import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class AirplaneService {


    private final AirplaneRepo airplaneRepo;

    public Airplane createAirplane(Airplane airplane){
        return airplaneRepo.save(airplane);
    }

    public void deleteAirplane(Long airplane_id){
        airplaneRepo.deleteById(airplane_id);
    }

    public List<Airplane> getAllAirplanes(){
        return  airplaneRepo.findAll();
    }
    
    public List<AirplaneToAirline> getAllAirplaneToAirlineDTOs(){
        return airplaneRepo.findAll()
                .stream()
                .map(this::airplaneTOairline)
                .collect(Collectors.toList());

    }

    private AirplaneToAirline airplaneTOairline(Airplane airplane){
        AirplaneToAirline AA = new AirplaneToAirline();
       AA.setCapacity(airplane.getCapacity());
       return AA;
       
}

public List<AirplaneToFlight> getAllAirplaneToFlight(){
    return airplaneRepo.findAll()
            .stream()
            .map(this::airplaneTOflight)
            .collect(Collectors.toList());

}

private AirplaneToFlight airplaneTOflight(Airplane airplane){
    AirplaneToFlight AF = new AirplaneToFlight();
    AF.setCapacity(airplane.getCapacity());
   return AF;
   
}

public List<AirplaneToAirplaneType> getAirplaneToAirplaneType(){
    return airplaneRepo.findAll()
            .stream()
            .map(this::airplaneTOairplaneType)
            .collect(Collectors.toList());

}

private AirplaneToAirplaneType airplaneTOairplaneType(Airplane airplane){
    AirplaneToAirplaneType AAP = new AirplaneToAirplaneType();
    AAP.setCapacity(airplane.getCapacity());
   return AAP;
   
}


}