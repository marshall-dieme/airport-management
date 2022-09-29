package com.regulus.airplaneservice.services;

import com.regulus.airplaneservice.dtos.AirplaneDto;
import com.regulus.airplaneservice.models.Airplane;
import com.regulus.airplaneservice.repositories.AirplaneRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AirplaneService {

    private final AirplaneRepository repository;

    private final Mapper mapper;

    public AirplaneService(AirplaneRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Airplane> getAirplane(){
        return repository.findAll();
    }

    public AirplaneDto getAirplane(int id){
        Airplane airplane =  repository.findById(id).get();
        return mapper.toDto(airplane);
    }

    public AirplaneDto createAirplane(AirplaneDto airplaneDto){
        Airplane airplane = mapper.toEntity(airplaneDto);
        airplane =  repository.save(airplane);
        return mapper.toDto(airplane);
    }

    public AirplaneDto updateAirplane(AirplaneDto airplaneDto, int id){
        AirplaneDto airplaneDto1 = getAirplane(id);
        Airplane airplane = mapper.toEntity(airplaneDto1);
        airplane.setCapacity(airplaneDto.getCapacity());
        airplane = repository.save(airplane);
        return mapper.toDto(airplane);
    }

    public void deleteAirplane(int id){
        AirplaneDto airplaneDto = getAirplane(id);
        Airplane airplane = mapper.toEntity(airplaneDto);
        repository.delete(airplane);
    }

}
