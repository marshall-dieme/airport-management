package com.saraya.Parkingservice.service;

import com.saraya.Parkingservice.dto.ParkingDto;
import com.saraya.Parkingservice.dto.PassengerDto;
import com.saraya.Parkingservice.model.Parking;
import com.saraya.Parkingservice.repository.ParkingRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class ParkingService {

    private static int number = 1;
    private final ParkingRepository repository;

    private final ModelMapper mapper;

    public List<ParkingDto> getAllParking() {
        return repository.findAll()
                .stream().map(parking -> mapper.map(parking, ParkingDto.class)).toList();
    }

    public Parking getParking(Long parking_id) {
        return repository.findById(parking_id).orElse(null);
    }

    public Parking saveParking(ParkingDto dto) {
        getPassengerByRestTemplate(dto);
        Parking parking = mapToEntity(dto);
        System.out.println(parking.toString());
        parking.setCar_no(generateCar_No());
        return repository.save(parking);
    }

    public Parking updateParking(ParkingDto dto) {
        getPassengerByRestTemplate(dto);
        Parking parking = mapToEntity(dto);
        return repository.save(parking);
    }

    public void deleteParking(Long parking_id) {
        repository.deleteById(parking_id);
    }

    public void getPassengerByRestTemplate(ParkingDto dto) {
        Map<String, String> passenger_value = new HashMap<>();
       /* passenger_value.put("passport_no", dto.getPassport_no());
        PassengerDto passengerDto = new RestTemplate()
                .getForEntity("http://localhost:8089/passengers/passenger-no/{passport_no}",
                        PassengerDto.class, passenger_value).getBody();*/
        passenger_value.put("firstname", dto.getPassenger_firstname());
        passenger_value.put("lastname", dto.getPassenger_lastname());
        /*Parking parking = mapper.map(dto, Parking.class);
        if (passengerDto != null) {
            parking.setPassenger_id(passengerDto.getPassenger_id());
        }*/
        PassengerDto passengerFN = new RestTemplate()
                .getForEntity("http://localhost:8089/passengers/{firstname}/{lastname}",
                        PassengerDto.class, passenger_value).getBody();
        System.out.println(passengerFN);
        Parking parking = mapToEntity(dto);

        if (passengerFN != null) {
            parking.setPassenger_id(passengerFN.getPassenger_id());
        }


    }

    private String generateCar_No() {
        return "Car_No-"+ number++;
    }


    public Parking mapToEntity(ParkingDto dto) {
        Parking parking = new Parking();
        parking.setParking_id(dto.getParking_id());
        parking.setName(dto.getName());
        parking.setEmail(dto.getEmail());
        parking.setCountry(dto.getCountry());
        parking.setAmount(dto.getAmount());
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        parking.setExit_date(LocalDate.parse(dto.getExit_date(), format));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        parking.setExit_time(LocalTime.parse(dto.getExit_time(), formatter));

        return parking;
    }
}
