package com.saraya.microserviceparkings.mappers;

import com.saraya.microserviceparkings.dto.ParkingDto;
import com.saraya.microserviceparkings.models.Parking;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ParkingMapper {
    Parking parkingDtoToParking(ParkingDto parkingDto);

    ParkingDto parkingToParkingDto(Parking parking);

    List<ParkingDto> parkingsToParkingDtos(List<Parking> parkings);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Parking updateParkingFromParkingDto(ParkingDto parkingDto, @MappingTarget Parking parking);
}
