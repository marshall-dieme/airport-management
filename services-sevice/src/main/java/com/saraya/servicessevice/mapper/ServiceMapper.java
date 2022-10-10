package com.saraya.servicessevice.mapper;

import com.saraya.servicessevice.bean.Services;
import com.saraya.servicessevice.dto.ServiceDto;

public class ServiceMapper {
    public Services toEntity(ServiceDto dto){
        Services service = new Services();
        service.setServiceId(dto.getServiceId());
        service.setName(dto.getName());
        return service;
    }
}
