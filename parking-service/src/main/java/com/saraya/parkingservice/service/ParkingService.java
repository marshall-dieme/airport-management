package com.saraya.parkingservice.service;

import com.saraya.parkingservice.bean.Parking;
import com.saraya.parkingservice.dto.ParkingDto;
import com.saraya.parkingservice.repository.ParkingRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ParkingService {

    private final ParkingRepo repo;

    public ParkingService(ParkingRepo repo) {
        this.repo = repo;
    }

    public List<Parking> getAll() {
        return repo.findAll();
    }

    public int getId(String name) {
        return repo.findByName(name).getId();
    }

    public Parking create(ParkingDto dto) {
        return repo.save(toEntity(dto));
    }

    private Parking toEntity(ParkingDto dto) {
        Parking parking = new Parking();
        parking.setName(dto.getName());
        parking.setCarNo(dto.getCarNo());
        return parking;
    }

    public Parking putPassengerForParking(int parkingId, int passportNo) {

        Parking parking = repo.findById(parkingId).get();

        RestTemplate restTemplate = new RestTemplate();
        int passengerId = restTemplate.getForEntity("http://localhost:8010/Passenger/"+passportNo, Integer.class).getBody();
        parking.getPassengerId().add(passengerId);

        return repo.save(parking);
    }
}
