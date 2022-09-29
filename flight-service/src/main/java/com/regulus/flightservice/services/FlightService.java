package com.regulus.flightservice.services;

import com.regulus.flightservice.dtos.FlightDto;
import com.regulus.flightservice.models.Flight;
import com.regulus.flightservice.repositories.FlightRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Transactional
public class FlightService {

    private final FlightRepository repository;

    private final RestTemplate restTemplate;
    private final Mapper mapper;

    public FlightService(FlightRepository repository, RestTemplate restTemplate, Mapper mapper) {
        this.repository = repository;
        this.restTemplate = restTemplate;
        this.mapper = mapper;
    }

    public List<Flight> getFlight(){
        return repository.findAll();
    }

    public FlightDto getFlight(int id){
        Flight flight =  repository.findById(id).get();
        return mapper.toDto(flight);
    }

    public FlightDto createFlight(FlightDto flightDto){
        Integer bookingId = restTemplate.getForEntity("http://booking-service/booking/seat/" + flightDto.getBooking_seat(),
                Integer.class).getBody();
        assert  bookingId != null;
        flightDto.setBooking_id(bookingId);
        Flight flight = mapper.toEntity(flightDto);
        flight =  repository.save(flight);
        return mapper.toDto(flight);
    }

    public FlightDto updateFlight(FlightDto flightDto, int id){
        FlightDto flightDto1 = getFlight(id);
        Flight flight = mapper.toEntity(flightDto1);
        flight.setFlight_id(flightDto.getFlight_id());
        flight.setFlight_no(flightDto.getFlight_no());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        flight.setDeparture_date(LocalDate.parse(flightDto.getDeparture_date(),formatter));
        flight.setArrival_date(LocalDate.parse(flightDto.getArrival_date(), formatter));
        flight.setFrom_to(flightDto.getFrom_to());
        flight.setBooking_id(flightDto.getBooking_id());
        flight = repository.save(flight);
        return mapper.toDto(flight);
    }

    public void deleteFlight(int id){
        FlightDto flightDto = getFlight(id);
        Flight flight = mapper.toEntity(flightDto);
        repository.delete(flight);
    }

    public Integer getFlightId(String flightNo) {
        return repository.findByFlight_no(flightNo);
    }
}
