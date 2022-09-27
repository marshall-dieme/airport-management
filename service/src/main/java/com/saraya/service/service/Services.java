package com.saraya.service.service;


import com.saraya.service.dto.ServiceDto;
import com.saraya.service.mapper.ServiceMapper;
import com.saraya.service.model.ModelService;
import com.saraya.service.repository.ServiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class Services {

    @Autowired
    private ServiceRepository repository;

    @Autowired
    private ServiceMapper mapper;

    @Autowired
    private RestTemplate restTemplate;

    public ServiceDto save(ServiceDto serviceDto){
        ModelService modelService1= mapper.toEntity(serviceDto);
        modelService1 = repository.save(modelService1);
        return mapper.toDto(modelService1);
    }

    public List<ModelService> findAll(){
        return repository.findAll();
    }

    public ServiceDto getServiceById(long service_id){
        ModelService modelService = repository.findById(service_id);
        return mapper.toDto(modelService);
    }


    public ServiceDto update(ServiceDto serviceDto, long service_id){
        ServiceDto serviceDto1 = getServiceById(service_id);
        ModelService modelService = mapper.toEntity(serviceDto1);
        modelService.setService_name(serviceDto.getService_name());
        modelService = repository.save(modelService);
        return mapper.toDto(modelService);


    }

    public void deleteById(long id){
        ServiceDto serviceDto = getServiceById(id);
        ModelService modelService = mapper.toEntity(serviceDto);
        repository.delete(modelService);
    }


//    public String getServiceName(String service_name) {
//        return repository.getByServiceName(service_name);
//    }
}
