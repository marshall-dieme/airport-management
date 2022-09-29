package com.regulus.airplaneservice.services;

import com.regulus.airplaneservice.dtos.AirplaneDto;
import com.regulus.airplaneservice.models.Airplane;
import org.springframework.stereotype.Service;

@Service
public class Mapper {

    public AirplaneDto toDto(Airplane airplane){
        AirplaneDto dto = new AirplaneDto();
        dto.setAirplane_id(airplane.getAirplane_id());
        dto.setCapacity(airplane.getCapacity());
        dto.setAirline_id(airplane.getAirline_id());
        dto.setAirplaneType_id(airplane.getAirplaneType_id());
        dto.setFlight_id(airplane.getFlight_id());
        return dto;
    }

    public Airplane toEntity(AirplaneDto dto){
        Airplane airplane = new Airplane();
        airplane.setAirplane_id(dto.getAirplane_id());
        airplane.setCapacity(dto.getCapacity());
        airplane.setAirline_id(dto.getAirline_id());
        airplane.setAirplaneType_id(dto.getAirplaneType_id());
        airplane.setFlight_id(dto.getFlight_id());
        return airplane;
    }
}
