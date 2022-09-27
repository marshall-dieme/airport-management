package com.saraya.flightservice.service;

import com.saraya.flightservice.bean.Flight;
import com.saraya.flightservice.dto.FlightDto;
import com.saraya.flightservice.repository.FlightRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
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

    public int getId(String flightNo) {
        return repo.findByFlightNo(flightNo).getId();
    }

    public Flight putbookingForFlight(int flightId, int priceBooking) {

        Flight flight = repo.findById(flightId).get();

        RestTemplate restTemplate = new RestTemplate();
        int bookingId = restTemplate.getForEntity("http://localhost:8006/Booking/"+priceBooking, Integer.class).getBody();
        flight.setBookingId(bookingId);

        return repo.save(flight);
    }
}

