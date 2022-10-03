package com.saraya.parking.service;

import com.saraya.parking.bean.Passenger;
import com.saraya.parking.dto.ParkingDto;
import com.saraya.parking.model.Parking;
import com.saraya.parking.proxies.PassengerProxy;
import com.saraya.parking.repository.ParkingRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ParkingService {

    private ParkingRepository repo;

    private PassengerProxy passengerProxy;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ModelMapper modelMapperParking;

    public List<Parking> getAllParking() {

        return repo.findAll();
    }

    public Parking getByIdParking(Long parking_id) {
        return repo.findById(parking_id).get();
    }

    public Parking createParking(ParkingDto parkingDto) {
        Parking details = getParking(parkingDto);

        return repo.save(details);
    }

    public Parking updateParking(ParkingDto parkingDto) {
        Parking details = getParking(parkingDto);

        return repo.save(details);
    }

    public void deleteParking(long parking_id) {
        repo.deleteById(parking_id);
    }

    private Parking getParking(ParkingDto parkingDto) {
        Passenger passenger = passengerProxy.getPassenger(parkingDto.getPassport_no());
        Parking details = mapper.map(parkingDto, Parking.class);
        details.setPassenger_id(passenger.getPassenger_id());
        return details;
    }

}
