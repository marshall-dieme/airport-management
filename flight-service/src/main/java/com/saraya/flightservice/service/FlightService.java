package com.saraya.flightservice.service;

import com.saraya.flightservice.bean.Flight;
import com.saraya.flightservice.dto.FlightDto;
import com.saraya.flightservice.repository.FlightRepo;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class FlightService {
    private final FlightRepo repo;

    public FlightService(FlightRepo repo) {
        this.repo = repo;
    }

    public List<Flight> getAll() {
        return repo.findAll();
    }

    public Flight create(FlightDto dto) {
        return repo.save(toEntity(dto));
    }

    private Flight toEntity(FlightDto dto) {
        Flight flight = new Flight();
        flight.setFlightNo(dto.getFlightNo());
        flight.setFrom(dto.getFrom());
        return flight;
    }

    public Flight putAirplaneForFlight(int flightId, int airplaneCapacity) {
        Flight flight = repo.findById(flightId).get();

        RestTemplate restTemplate = new RestTemplate();
        int airpplaneId = restTemplate.getForEntity("http://localhost:8002/Airplane/"+airplaneCapacity, Integer.class).getBody();
        flight.getAirplaneId().add(airpplaneId);

        return repo.save(flight);
    }
}

