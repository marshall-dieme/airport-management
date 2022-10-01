package com.saraya.microserviceairplanetypes.mappers;


import com.saraya.microserviceairplanetypes.dto.AirplaneTypeDto;
import com.saraya.microserviceairplanetypes.models.AirplaneType;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AirplaneTypeMapper {
    AirplaneType airplaneTypeDtoToAirplaneType(AirplaneTypeDto airplaneTypeDto);

    AirplaneTypeDto airplaneTypeToAirplaneTypeDto(AirplaneType airplaneType);

    List<AirplaneTypeDto> airplaneTypesToAirplaneTypeDtos(List<AirplaneType> airplaneTypes);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AirplaneType updateAirplaneTypeFromAirplaneTypeDto(AirplaneTypeDto airplaneTypeDto, @MappingTarget AirplaneType airplaneType);
}
