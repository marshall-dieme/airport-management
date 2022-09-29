package com.regulus.airplanetypeservice.services;

import com.regulus.airplanetypeservice.dtos.AirplaneTypeDto;
import com.regulus.airplanetypeservice.models.AirplaneType;
import com.regulus.airplanetypeservice.repositories.AirplaneTypeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AirplaneTypeService {

    private final AirplaneTypeRepository repository;

    private final Mapper mapper;

    public AirplaneTypeService(AirplaneTypeRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<AirplaneType> getAirplaneType(){
        return repository.findAll();
    }

    public AirplaneTypeDto getAirplaneType(int id){
        AirplaneType airplaneType =  repository.findById(id).get();
        return mapper.toDto(airplaneType);
    }

    public AirplaneTypeDto createAirplaneType(AirplaneTypeDto airplaneTypeDto){
        AirplaneType airplaneType = mapper.toEntity(airplaneTypeDto);
        airplaneType =  repository.save(airplaneType);
        return mapper.toDto(airplaneType);
    }

    public AirplaneTypeDto updateAirplaneType(AirplaneTypeDto airplaneTypeDto, int id){
        AirplaneTypeDto airplaneTypeDto1 = getAirplaneType(id);
        AirplaneType airplaneType = mapper.toEntity(airplaneTypeDto1);
        airplaneType.setAirplane_type_id(airplaneTypeDto.getAirplane_type_id());
        airplaneType.setAirplane_type_identifier(airplaneTypeDto.getAirplane_type_identifier());
        airplaneType.setDescription(airplaneTypeDto.getDescription());
        airplaneType = repository.save(airplaneType);
        return mapper.toDto(airplaneType);
    }

    public void deleteAirplaneType(int id){
        AirplaneTypeDto airplaneTypeDto = getAirplaneType(id);
        AirplaneType airplaneType = mapper.toEntity(airplaneTypeDto);
        repository.delete(airplaneType);
    }

    public Integer getAirplaneTypeId(String identifier) {
        return repository.findByAirplane_type_identifier(identifier);
    }
}
