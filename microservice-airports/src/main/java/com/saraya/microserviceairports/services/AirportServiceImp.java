package com.saraya.microserviceairports.services;

import com.saraya.microserviceairports.exceptions.ResourceNotFoundException;
import com.saraya.microserviceairports.models.Airport;
import com.saraya.microserviceairports.repositories.AirportRepository;
import com.saraya.microserviceairports.services.AirportService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AirportServiceImp implements AirportService {
    private final AirportRepository airportRepository;

    public AirportServiceImp(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public Airport add(Airport airport) throws ResourceNotFoundException {
        return getAirport(airport);
    }

    @Override
    public Airport update(Airport airport) throws ResourceNotFoundException {
        return getAirport(airport);
    }

    private Airport getAirport(Airport airport) throws ResourceNotFoundException {
        if(airport.getServicesId()!=null){
            try {
                Map<String,Long> paramServices = new HashMap<>();
                paramServices.put("services_id",airport.getServicesId());
                Long servicesId = new RestTemplate().getForEntity("http://localhost:9007/services/services_id/{services_id}",
                        Long.class,paramServices).getBody();

                airport.setServicesId(servicesId);
            }catch (Exception e){
                throw new ResourceNotFoundException(String.format("Service ID = %d not found",airport.getServicesId()));
            }

        }

       if (airport.getAirportGeoId()!=null){
           try {
               Map<String,Long> paramAirportGeos = new HashMap<>();
               paramAirportGeos.put("airportgeo_id",airport.getAirportGeoId());
               Long airportGeoId = new RestTemplate().getForEntity("http://localhost:9005/airportgeos/airportgeo_id/{airportgeo_id}",
                       Long.class,paramAirportGeos).getBody();

               airport.setAirportGeoId(airportGeoId);
           }catch (Exception e){
               throw new ResourceNotFoundException(String.format("AirportGeo ID = %d not found",airport.getAirportGeoId()));
           }
       }

        if (airport.getAirlineId()!=null){
            try {
                Map<String,Long> paramAirlines = new HashMap<>();
                paramAirlines.put("airline_id",airport.getAirlineId());
                Long airlineId = new RestTemplate().getForEntity("http://localhost:9001/airlines/airline_id/{airline_id}",
                        Long.class,paramAirlines).getBody();

                airport.setAirportGeoId(airlineId);
            }catch (Exception e){
                throw new ResourceNotFoundException(String.format("Airline ID = %d not found",airport.getAirportGeoId()));
            }
        }

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
