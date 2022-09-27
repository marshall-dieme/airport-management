package com.saraya.service.mapper;


import com.saraya.service.dto.ServiceDto;
import com.saraya.service.model.ModelService;
import org.springframework.stereotype.Service;

@Service
public class ServiceMapper {

    public ServiceDto toDto(ModelService modelService){
        ServiceDto dto = new ServiceDto();
        dto.setService_id(modelService.getService_id());
        dto.setService_name(modelService.getService_name());
        return dto;
    }

    public ModelService toEntity(ServiceDto serviceDto){
        ModelService modelService = new ModelService();
        modelService.setService_id(serviceDto.getService_id());
        modelService.setService_name(modelService.getService_name());
        return modelService;
    }
}
