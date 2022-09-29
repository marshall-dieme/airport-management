package com.saraya.microserviceairportgeos.mappers;


import com.saraya.microserviceairportgeos.dto.AirportGeoDto;
import com.saraya.microserviceairportgeos.models.AirportGeo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AirportGeoMapper {
    AirportGeo airportGeoDtoToAirportGeo(AirportGeoDto airportGeoDto);

    AirportGeoDto airportGeoToAirportGeoDto(AirportGeo airportGeo);

    List<AirportGeoDto> airportGeosToAirportGeoDtos(List<AirportGeo> airportGeos);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AirportGeo updateAirportGeoFromAirportGeoDto(AirportGeoDto airportGeoDto, @MappingTarget AirportGeo airportGeo);
}
