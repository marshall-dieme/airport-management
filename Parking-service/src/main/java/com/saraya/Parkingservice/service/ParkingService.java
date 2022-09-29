package com.saraya.Parkingservice.service;

import com.saraya.Parkingservice.dto.ParkingDto;
import com.saraya.Parkingservice.model.Parking;
import com.saraya.Parkingservice.proxies.PassengerProxy;
import com.saraya.Parkingservice.repository.ParkingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class ParkingService {

    private static int number = 1;
    private final ParkingRepository repository;

    private final PassengerProxy passengerProxy;
    private final ModelMapper mapper;



    public List<ParkingDto> getAllParking() {
        List<ParkingDto> dtos = new ArrayList<>();
        for (Parking parking: repository.findAll()) {
            ParkingDto dto = mapper.map(parking, ParkingDto.class);
            dto.setPassport_no(getParking(parking.getPassenger_id()).getPassport_no());
            dtos.add(dto);
        }
        return dtos;
    }

    public ParkingDto getParking(Long parking_id) {
        ParkingDto dto = new ParkingDto();
        Parking parking = repository.findById(parking_id).orElse(null);
        if (parking != null) {
            dto = mapper.map(parking, ParkingDto.class);
            dto.setPassport_no(passengerProxy.getPassenger(parking.getPassenger_id()).getPassport_no());
        }
        return dto;
    }

    public Parking saveParking(ParkingDto dto) {
        Parking parking = getParking(dto);
        parking.setCar_no(generateCar_No());
        return repository.save(parking);
    }

    public Parking updateParking(ParkingDto dto) {
        Parking parking = getParking(dto);
        return repository.save(parking);
    }

    /************** Generator Car_no ************/
    private String generateCar_No() {
        return "Car_No-" + number++;
    }

    /************ Get Parking ****************/
    private Parking getParking(ParkingDto dto) {
        Parking parking = mapper.map(dto, Parking.class);
        parking.setPassenger_id(passengerProxy.getPassengerByPassenger_no(dto.getPassport_no()).getPassenger_id());
        return parking;
    }


}
