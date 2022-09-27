package com.saraya.Airplane_Type.service;

import com.saraya.Airplane_Type.dto.AirplaneTypeToAirplaneDTO;
import com.saraya.Airplane_Type.entity.AirplaneType;
import com.saraya.Airplane_Type.repository.AirplaneRepo;
import com.saraya.Airplane_Type.repository.AirplaneTypeRepo;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;


@Transactional
@RequiredArgsConstructor
@Service
public class AirplaneService {

    // private final AirplaneRepo airplaneRepo;
    private final AirplaneTypeRepo airplaneTypeRepo;

    public List<AirplaneTypeToAirplaneDTO> getAllAirplaneTypeToAirplaneDTOs(){
        return airplaneTypeRepo.findAll()
                .stream()
                .map(this::convertToDot)
                .collect(Collectors.toList());

    }

    private AirplaneTypeToAirplaneDTO convertToDot(AirplaneType airplaneType){
        AirplaneTypeToAirplaneDTO ATS = new AirplaneTypeToAirplaneDTO();
       ATS.setAirplane_type_id(airplaneType.getAirplane_type_id());
       ATS.setAirplane_type_identifier(airplaneType.getAirplane_type_identifier());
       ATS.setDescription(airplaneType.getDescription());
        return ATS;
       
    }

    public List<AirplaneType> getALLAirplaneTypes(){
        return airplaneTypeRepo.findAll();

    }

    public AirplaneType createAirplaneType(AirplaneType airplaneType){
       return airplaneTypeRepo.save(airplaneType);
        
    }
    
    
    public void deleteAirplaneType(Long airplane_type_id){
        airplaneTypeRepo  .deleteById(airplane_type_id);
    }

}