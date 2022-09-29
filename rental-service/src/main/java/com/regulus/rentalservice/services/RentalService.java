package com.regulus.rentalservice.services;

import com.regulus.rentalservice.dtos.RentalDto;
import com.regulus.rentalservice.models.Rental;
import com.regulus.rentalservice.repositories.RentalRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Transactional
public class RentalService {

    private final RentalRepository repository;

    private final Mapper mapper;

    public RentalService(RentalRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Rental> getRental(){
        return repository.findAll();
    }

    public RentalDto getRental(int id){
        Rental rental =  repository.findById(id).get();
        return mapper.toDto(rental);
    }

    public RentalDto createRental(RentalDto rentalDto){
        Rental rental = mapper.toEntity(rentalDto);
        rental =  repository.save(rental);
        return mapper.toDto(rental);
    }

    public RentalDto updateRental(RentalDto rentalDto, int id){
        RentalDto rentalDto1 = getRental(id);
        Rental rental = mapper.toEntity(rentalDto1);
        rental.setRental_id(rentalDto.getRental_id());
        rental.setName(rentalDto.getName());
        rental.setEmail(rentalDto.getEmail());
        rental.setContact(rentalDto.getContact());
        rental.setLicence_no(rentalDto.getLicence_no());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH-mm-ss");
        rental.setPickup_date(LocalDate.parse(rentalDto.getPickup_date(), formatter));
        rental.setPickup_time(LocalTime.parse(rentalDto.getPickup_time(), formatter1));
        rental.setReturn_date(LocalDate.parse(rentalDto.getReturn_date(), formatter));
        rental.setReturn_time(LocalTime.parse(rentalDto.getReturn_time(), formatter1));
        rental.setCar_no(rentalDto.getCar_no());
        rental.setAmount(rentalDto.getAmount());
        rental = repository.save(rental);
        return mapper.toDto(rental);
    }

    public void deleteRental(int id){
        RentalDto rentalDto = getRental(id);
        Rental rental = mapper.toEntity(rentalDto);
        repository.delete(rental);
    }

    public Integer getRentalId(String name) {
        return repository.findByName(name);
    }

}
