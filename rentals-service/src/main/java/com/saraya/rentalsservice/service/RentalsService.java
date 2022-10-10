package com.saraya.rentalsservice.service;

import com.saraya.rentalsservice.bean.Rentals;
import com.saraya.rentalsservice.dto.RentalsDto;
import com.saraya.rentalsservice.mapper.RentalsMapper;
import com.saraya.rentalsservice.repository.RentalsRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RentalsService {

    private final RentalsRepo repo;

    public RentalsService(RentalsRepo repo) {
        this.repo = repo;
    }

    private RentalsMapper mapper = new RentalsMapper();

    public List<Rentals> getAll() {
        return repo.findAll();
    }

    public int getId(String name) {
        return repo.findByName(name).getId();
    }

    public Rentals create(RentalsDto dto) {
        return repo.save(mapper.toEntity(dto));
    }

    public Rentals putPassengerForRentals(int rentalsId, int passportNo) {

        Rentals rentals = repo.findById(rentalsId).get();

        RestTemplate restTemplate = new RestTemplate();
        int passengerId = restTemplate.getForEntity("http://localhost:8010/Passenger/"+passportNo, Integer.class).getBody();
        rentals.getPassengerId().add(passengerId);

        return repo.save(rentals);
    }
}
