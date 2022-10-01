package com.saraya.microserviceairlines.mappers;

import com.saraya.microserviceairlines.dto.AirlineDto;
import com.saraya.microserviceairlines.models.Airline;
import org.mapstruct.*;

import java.util.List;
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AirlineMapper {
    Airline airlineDtoToAirline(AirlineDto airlineDto);

    AirlineDto airlineToAirlineDto(Airline airline);

    List<AirlineDto> airlinesToAirlineDtos(List<Airline> airlines);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Airline updateAirlineFromAirlineDto(AirlineDto airlineDto, @MappingTarget Airline airline);
}
