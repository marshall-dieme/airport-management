package com.spring.airlinesservices.sercice;


import com.spring.airlinesservices.DTO.AirlineDto;
import com.spring.airlinesservices.bean.Airline;
import com.spring.airlinesservices.repository.AirlineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirlineService {
    @Autowired
    private AirlineRepo airlineRepo;

    public List<Airline> getAll(){
        return airlineRepo.findAll();
    }

    public Optional<Airline> getById(int id){
        return airlineRepo.findById(id);
    }

    public Airline create(AirlineDto dto){
        Airline airline = new Airline();
        changeToEntity(dto,airline);
        return airlineRepo.save(airline);
    }
    public Airline update(AirlineDto airlineDto) {
        Airline airline = new Airline();
        changeToEntity(airlineDto,airline);
        return airlineRepo.save(airline) ;
    }
    public void delete(int id){
        airlineRepo.deleteById(id);
    }

    void changeToEntity(AirlineDto dto , Airline airline){
        airline.setAirlineName(dto.getAirlineName());
        airline.setIata(dto.getIata());
        airline.setAirportId(dto.getAirportId());
        airline.setIacao(dto.getIacao());
    }
}
