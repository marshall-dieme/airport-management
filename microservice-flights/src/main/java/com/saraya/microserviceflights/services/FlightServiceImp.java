package com.saraya.microserviceflights.services;

import com.saraya.microserviceflights.exceptions.ResourceNotFoundException;
import com.saraya.microserviceflights.models.Flight;
import com.saraya.microserviceflights.repositories.FlightRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FlightServiceImp implements FlightService {
    private final FlightRepository flightRepository;

    public FlightServiceImp(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public Flight add(Flight flight) {
        return this.flightRepository.save(flight);
    }

    @Override
    public Flight update(Flight flight) {
        return this.flightRepository.save(flight);
    }

    @Override
    public Flight getFlight(Long flight_id) throws ResourceNotFoundException {
        Optional<Flight> flight = this.flightRepository.findById(flight_id);
        if (!flight.isPresent())
            throw new ResourceNotFoundException("Flight not available");
        return flight.get();
    }

    @Override
    public Page<Flight> getFlights(Pageable pageable) {
        return this.flightRepository.findAll(pageable);
    }

    @Override
    public void delete(Long flight_id) throws ResourceNotFoundException {
      if (!this.existFlight(flight_id))
          throw new ResourceNotFoundException("impossible to remove this Flight");

      this.flightRepository.deleteById(flight_id);
    }

    @Override
    public boolean existFlight(Long flight_id) {
        return this.flightRepository.existsById(flight_id);
    }
}
