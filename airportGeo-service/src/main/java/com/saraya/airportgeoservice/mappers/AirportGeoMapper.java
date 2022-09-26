package com.saraya.airportgeoservice.mappers;


import com.saraya.airportgeoservice.dto.AirportGeoDto;
import com.saraya.airportgeoservice.models.AirportGeo;
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
