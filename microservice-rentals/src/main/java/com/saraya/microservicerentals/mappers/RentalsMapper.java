package com.saraya.microservicerentals.mappers;

import com.saraya.microservicerentals.dto.RentalsDto;
import com.saraya.microservicerentals.models.Rentals;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RentalsMapper {
    Rentals rentalsDtoToRentals(RentalsDto rentalsDto);

    RentalsDto rentalsToRentalsDto(Rentals rentals);

    List<RentalsDto> rentalssToRentalsDtos(List<Rentals> rentalss);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Rentals updateRentalsFromRentalsDto(RentalsDto rentalsDto, @MappingTarget Rentals rentals);
}
