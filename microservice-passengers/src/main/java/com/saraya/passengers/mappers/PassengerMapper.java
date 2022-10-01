package com.saraya.passengers.mappers;


import com.saraya.passengers.dto.PassengerDto;
import com.saraya.passengers.models.Passenger;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PassengerMapper {
    Passenger passengerDtoToPassenger(PassengerDto passengerDto);

    PassengerDto passengerToPassengerDto(Passenger passenger);

    List<PassengerDto> passengersToPassengerDtos(List<Passenger> passengers);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Passenger updatePassengerFromPassengerDto(PassengerDto passengerDto, @MappingTarget Passenger passenger);
}
