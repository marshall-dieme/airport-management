package com.saraya.airplaneservice.mapper;

import com.saraya.airplaneservice.bean.Airplane;
import com.saraya.airplaneservice.dto.AirplaneDto;

public class AirplaneMapper {
    public Airplane toEntity(AirplaneDto dto) {
        Airplane airplane = new Airplane();
        airplane.setCapacity(dto.getCapacity());
        return airplane;
    }
}
