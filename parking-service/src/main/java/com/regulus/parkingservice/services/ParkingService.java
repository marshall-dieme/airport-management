package com.regulus.parkingservice.services;

import com.regulus.parkingservice.dtos.ParkingDto;
import com.regulus.parkingservice.models.Parking;
import com.regulus.parkingservice.repositories.ParkingRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Transactional
public class ParkingService {

    private final ParkingRepository repository;

    private final Mapper mapper;

    public ParkingService(ParkingRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Parking> getParking(){
        return repository.findAll();
    }

    public ParkingDto getParking(int id){
        Parking parking =  repository.findById(id).get();
        return mapper.toDto(parking);
    }

    public ParkingDto createParking(ParkingDto parkingDto){
        Parking parking = mapper.toEntity(parkingDto);
        parking =  repository.save(parking);
        return mapper.toDto(parking);
    }

    public ParkingDto updateParking(ParkingDto parkingDto, int id){
        ParkingDto parkingDto1 = getParking(id);
        Parking parking = mapper.toEntity(parkingDto1);
        parking.setParking_id(parkingDto.getParking_id());
        parking.setName(parkingDto.getName());
        parking.setEmail(parkingDto.getEmail());
        parking.setContact(parkingDto.getContact());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH-mm-ss");
        parking.setEntry_date(LocalDate.parse(parkingDto.getEntry_date(), formatter));
        parking.setEntry_time(LocalTime.parse(parkingDto.getEntry_time(), formatter1));
        parking.setExit_date(LocalDate.parse(parkingDto.getExit_date(), formatter));
        parking.setExit_time(LocalTime.parse(parkingDto.getExit_time(), formatter1));
        parking.setCar_no(parkingDto.getCar_no());
        parking.setAmount(parkingDto.getAmount());
        parking = repository.save(parking);
        return mapper.toDto(parking);
    }

    public void deleteParking(int id){
        ParkingDto parkingDto = getParking(id);
        Parking parking = mapper.toEntity(parkingDto);
        repository.delete(parking);
    }

    public Integer getParkingId(String name) {
        return repository.findByName(name);
    }

}
