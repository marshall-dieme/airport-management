package com.saraya.microserviceairports.servicesImpl;

import com.saraya.microserviceairports.exceptions.ResourceNotFoundException;
import com.saraya.microserviceairports.models.Airport;
import com.saraya.microserviceairports.repositories.AirportRepository;
import com.saraya.microserviceairports.services.AirportService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirportServiceImp implements AirportService {
    private final AirportRepository airportRepository;

    public AirportServiceImp(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public Airport add(Airport airport) {
        return this.airportRepository.save(airport);
    }

    @Override
    public Airport update(Airport airport) {
        return this.airportRepository.save(airport);
    }

    @Override
    public Airport getAirport(Long airport_id) throws ResourceNotFoundException {
        Optional<Airport> airport = this.airportRepository.findById(airport_id);
        if (!airport.isPresent())
            throw new ResourceNotFoundException("Airport not available");
        return airport.get();
    }

    @Override
    public Page<Airport> getAirports(Pageable pageable) {
        return this.airportRepository.findAll(pageable);
    }

    @Override
    public void delete(Long airport_id) throws ResourceNotFoundException {
      if (!this.existAirport(airport_id))
          throw new ResourceNotFoundException("impossible to remove this Airport");

      this.airportRepository.deleteById(airport_id);
    }

    @Override
    public boolean existAirport(Long airport_id) {
        return this.airportRepository.existsById(airport_id);
    }
}
