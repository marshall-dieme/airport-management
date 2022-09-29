package com.regulus.serviceservice.services;


import com.regulus.serviceservice.dtos.ServiceDto;
import com.regulus.serviceservice.models.Service;

@org.springframework.stereotype.Service
public class Mapper {

    public ServiceDto toDto(Service service){
        ServiceDto dto = new ServiceDto();
        dto.setService_id(service.getService_id());
        dto.setService_name(service.getService_name());
        dto.setAirport_id(service.getAirport_id());
        return dto;
    }

    public Service toEntity(ServiceDto serviceDto){
        Service service = new Service();
        service.setService_id(serviceDto.getService_id());
        service.setService_name(serviceDto.getService_name());
        service.setAirport_id(serviceDto.getAirport_id());
        return service;
    }
}
