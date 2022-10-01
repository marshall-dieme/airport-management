package com.saraya.passengerdetails.mappers;

import com.saraya.passengerdetails.dto.PassengerDetailsDto;
import com.saraya.passengerdetails.models.PassengerDetails;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PassengerDetailsMapper {
    PassengerDetails passengerDetailsDtoToPassengerDetails(PassengerDetailsDto passengerDetailsDto);

    PassengerDetailsDto passengerDetailsToPassengerDetailsDto(PassengerDetails passengerDetails);

    List<PassengerDetailsDto> passengerDetailssToPassengerDetailsDtos(List<PassengerDetails> passengerDetailss);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PassengerDetails updatePassengerDetailsFromPassengerDetailsDto(PassengerDetailsDto passengerDetailsDto, @MappingTarget PassengerDetails passengerDetails);
}
