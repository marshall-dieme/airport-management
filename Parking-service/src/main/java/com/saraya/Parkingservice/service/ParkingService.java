package com.saraya.Parkingservice.service;

import com.saraya.Parkingservice.dto.ParkingDto;
import com.saraya.Parkingservice.dto.PassengerDto;
import com.saraya.Parkingservice.dto.ResponseTemplateValueObject;
import com.saraya.Parkingservice.model.Parking;
import com.saraya.Parkingservice.repository.ParkingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class ParkingService {

    private static int number = 1;
    private final ParkingRepository repository;

    private final RestTemplate restTemplate;

       private final ModelMapper mapper;



    public List<ParkingDto> getAllParking() {
        return repository.findAll()
                .stream().map(parking -> mapper.map(parking, ParkingDto.class)).toList();
    }

    public Parking getParking(Long parking_id) {
        return repository.findById(parking_id).orElse(null);
    }

    public Parking saveParking(ParkingDto dto) {
        Parking parking = mapToEntity(dto);
        parking.setCar_no(generateCar_No());
        return repository.save(parking);
    }

    public Parking updateParking(ParkingDto dto) {
        Parking parking =  mapToEntity(dto);
        return repository.save(parking);
    }

    private String generateCar_No() {
        return "Car_No-" + number++;
    }


    /******************* Get Parking with Passenger *****************************/
    public ResponseTemplateValueObject getParkingPassenger(Long parking_id) {
        ResponseTemplateValueObject template = new ResponseTemplateValueObject();
        Parking parking = repository.findByParking_id(parking_id);

        PassengerDto passengerDto = restTemplate.getForObject(
                "http://localhost:8089/passengers/" + parking.getPassenger_id(), PassengerDto.class);

        template.setParking(parking);
        template.setPassengerDto(passengerDto);

        return template;
    }


/**************** Mapper to Entity **********************/
    public Parking mapToEntity(ParkingDto dto) {
        Parking parking = new Parking();
        parking.setParking_id(dto.getParking_id());
        parking.setPassenger_id(dto.getPassenger_id());
        parking.setName(dto.getName());
        parking.setEmail(dto.getEmail());
        parking.setCountry(dto.getCountry());
        parking.setAmount(dto.getAmount());
        parking.setExit_date(LocalDate.parse(dto.getExit_date(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        parking.setExit_time(LocalTime.parse(dto.getExit_time(), DateTimeFormatter.ofPattern("HH:mm:ss")));

        return parking;
    }
}
