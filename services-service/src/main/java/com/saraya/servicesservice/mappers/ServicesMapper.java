package com.saraya.servicesservice.mappers;

import com.saraya.servicesservice.dto.ServicesDto;
import com.saraya.servicesservice.models.Services;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ServicesMapper {
    Services servicesDtoToServices(ServicesDto servicesDto);

    ServicesDto servicesToServicesDto(Services services);

    List<ServicesDto> servicesToServicesDtos(List<Services> servicesList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Services updateServicesFromServicesDto(ServicesDto servicesDto, @MappingTarget Services services);
}
