package com.regulus.airplanetypeservice.services;

import com.regulus.airplanetypeservice.dtos.AirplaneTypeDto;
import com.regulus.airplanetypeservice.models.AirplaneType;
import org.springframework.stereotype.Service;

@Service
public class Mapper {

    public AirplaneTypeDto toDto(AirplaneType airplaneType){
        AirplaneTypeDto dto = new AirplaneTypeDto();
        dto.setAirplane_type_id(airplaneType.getAirplane_type_id());
        dto.setAirplane_type_identifier(airplaneType.getAirplane_type_identifier());
        dto.setDescription(airplaneType.getDescription());
        return dto;
    }

    public AirplaneType toEntity(AirplaneTypeDto dto){
        AirplaneType airplaneType = new AirplaneType();
        airplaneType.setAirplane_type_id(dto.getAirplane_type_id());
        airplaneType.setAirplane_type_identifier(dto.getAirplane_type_identifier());
        airplaneType.setDescription(dto.getDescription());
        return airplaneType;
    }

}
