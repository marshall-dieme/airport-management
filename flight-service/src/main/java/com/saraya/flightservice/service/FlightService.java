package com.saraya.flightservice.service;

import com.saraya.flightservice.bean.Flight;
import com.saraya.flightservice.dto.FlightDto;
import com.saraya.flightservice.mapper.FlightMapper;
import com.saraya.flightservice.repository.FlightRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FlightService {
    private final FlightRepo repo;

    public FlightService(FlightRepo repo) {
        this.repo = repo;
    }

    FlightMapper mapper = new FlightMapper();

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

    public List<Flight> getAll() {
        return repo.findAll();
    }

    public Flight create(FlightDto dto) {
        return repo.save(mapper.toEntity(dto));
    }

    public Flight update(FlightDto dto) {
        return repo.save(mapper.toEntity(dto));
    }

    public void delete(FlightDto dto) {
        repo.delete(mapper.toEntity(dto));
    }

    public String putTimeTableForFlight(int flightId, String airline) {

        RestTemplate restTemplate = new RestTemplate();
        int timeTableId = restTemplate.getForEntity("http://localhost:8014/TimeTable/"+airline,
                Integer.class).getBody();

        Map<String, Integer> urlValues = new HashMap<>();
        urlValues.put("flightId", flightId);
        urlValues.put("timeTableId", timeTableId);
        new RestTemplate().getForEntity("http://localhost:8025/Relation2/{timeTableId}/{flightId}", void.class, urlValues).getBody();

        return "add succefull";
    }
}

