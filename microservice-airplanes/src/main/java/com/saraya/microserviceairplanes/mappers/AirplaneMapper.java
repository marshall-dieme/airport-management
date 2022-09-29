package com.saraya.microserviceairplanes.mappers;


import com.saraya.microserviceairplanes.dto.AirplaneDto;
import com.saraya.microserviceairplanes.models.Airplane;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AirplaneMapper {
    Airplane airplaneDtoToAirplane(AirplaneDto airplaneDto);

    AirplaneDto airplaneToAirplaneDto(Airplane airplane);

    List<AirplaneDto> airplanesToAirplaneDtos(List<Airplane> airplanes);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Airplane updateAirplaneFromAirplaneDto(AirplaneDto airplaneDto, @MappingTarget Airplane airplane);
}
