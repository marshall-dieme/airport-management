package com.saraya.airplanetypeservice.mapper;

import com.saraya.airplanetypeservice.bean.AirplaneType;
import com.saraya.airplanetypeservice.dto.AirplaneTypeDto;

public class AirplanTypeMapper {
    public AirplaneType toEntity(AirplaneTypeDto dto) {
        AirplaneType airplaneType = new AirplaneType();
        airplaneType.setAirplaneTypeIdentifier(dto.getAirplaneTypeIdentifier());
        airplaneType.setDescription(dto.getDescription());
        return airplaneType;
    }

}
