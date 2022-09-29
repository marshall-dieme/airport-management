package com.regulus.serviceservice.services;

import com.regulus.serviceservice.dtos.ServiceDto;
import com.regulus.serviceservice.models.Service;
import com.regulus.serviceservice.repositories.ServiceRepository;

import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class ServiceService {

    private final ServiceRepository repository;

    private final Mapper mapper;

    public ServiceService(ServiceRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Service> getService(){
        return repository.findAll();
    }

    public ServiceDto getService(int id){
        Service service =  repository.findById(id).get();
        return mapper.toDto(service);
    }

    public Integer getServiceID(String name){
        return repository.findByService_name(name);
    }

    public ServiceDto createService(ServiceDto serviceDto){
        Service service = mapper.toEntity(serviceDto);
        service =  repository.save(service);
        return mapper.toDto(service);
    }

    public ServiceDto updateService(ServiceDto serviceDto, int id){
        ServiceDto serviceDto1 = getService(id);
        Service service = mapper.toEntity(serviceDto1);
        service.setService_name(serviceDto.getService_name());
        service = repository.save(service);
        return mapper.toDto(service);
    }

    public void deleteService(int id){
        ServiceDto serviceDto = getService(id);
        Service service = mapper.toEntity(serviceDto);
        repository.delete(service);
    }
}
