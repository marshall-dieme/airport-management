package com.saraya.flightservice.service;

import com.saraya.flightservice.model.Flight;
import com.saraya.flightservice.model.FlightDto;
import com.saraya.flightservice.repos.FlightRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class FlightService {
    private final FlightRepo repo;

    public FlightService(FlightRepo repo) {
        this.repo = repo;
    }


    public List<Flight> getAll(){
        return repo.findAll();

    }



    public Long getFlightId(String flightNo) {
        return repo.getFlightId(flightNo);
    }


    public Flight create(FlightDto dto){
        Flight flight = new Flight();
        changeToModel(dto, flight);
        return repo.save(flight);
    }

    public Flight update(Flight flight){
        return repo.save(flight);
    }


    private static void changeToModel(FlightDto dto, Flight flight) {
        flight.setFlightNo(dto.getFlightNo());


        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate departureDate = LocalDate.parse(dto.getDepartureDate(), format);
        flight.setDepartureDate(departureDate);

        LocalDate arrivalDate = LocalDate.parse(dto.getArrivalDate(), format);
        flight.setArrivalDate(arrivalDate);

        flight.setFromm(dto.getFromm());
        flight.setToo(dto.getToo());
    }



    public void delete(Long id ){
        repo.deleteById(id);
    }
}


