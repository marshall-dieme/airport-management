package com.saraya.microserviceairports.mappers;

import com.saraya.microserviceairports.dto.AirportDto;
import com.saraya.microserviceairports.models.Airport;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AirportMapper {
    Airport airportDtoToAirport(AirportDto airportDto);

    AirportDto airportToAirportDto(Airport airport);

    List<AirportDto> airportsToAirportDtos(List<Airport> airports);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Airport updateAirportFromAirportDto(AirportDto airportDto, @MappingTarget Airport airport);
}
