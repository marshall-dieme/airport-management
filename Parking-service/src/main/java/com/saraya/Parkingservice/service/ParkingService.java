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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class ParkingService {

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
        Parking parking = mapper.map(dto, Parking.class);
        parking.setEntry_date(LocalDate.now());
        parking.setEntry_time(LocalTime.now());
        return repository.save(parking);
    }

    public Parking updateParking(ParkingDto dto) {
        getPassengerByRestTemplate(dto);
        Parking parking = mapper.map(dto, Parking.class);
        return repository.save(parking);
    }

    public void deleteParking(Long parking_id) {
        repository.deleteById(parking_id);
    }

    public void getPassengerByRestTemplate(ParkingDto dto) {
        Map<String, String> passenger_value = new HashMap<>();
        passenger_value.put("passport_no", dto.getPassport_no());
        PassengerDto passengerDto = new RestTemplate()
                .getForEntity("http://localhost:8089/passengers/passenger-no/{passport_no}",
                        PassengerDto.class, passenger_value).getBody();
        passenger_value.put("firstname", dto.getPassenger_firstname());
        passenger_value.put("lastname", dto.getPassenger_lastname());
        Parking parking = mapper.map(dto, Parking.class);
        if (passengerDto != null) {
            parking.setPassenger_id(passengerDto.getPassenger_id());
        }
        PassengerDto passengerFN = new RestTemplate()
                .getForEntity("http://localhost:8089/passengers/{firstname}/{lastname}",
                        PassengerDto.class, passenger_value).getBody();
        System.out.println(dto);
        if (passengerFN != null) {
            parking.setPassenger_id(passengerFN.getPassenger_id());
        }

    }
}
