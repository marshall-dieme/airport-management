package com.saraya.microserviceflights.mappers;

import com.saraya.microserviceflights.dto.FlightDto;
import com.saraya.microserviceflights.models.Flight;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface FlightMapper {
    Flight flightDtoToFlight(FlightDto flightDto);

    FlightDto flightToFlightDto(Flight flight);

    List<FlightDto> flightsToFlightDtos(List<Flight> flights);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Flight updateFlightFromFlightDto(FlightDto flightDto, @MappingTarget Flight flight);
}
