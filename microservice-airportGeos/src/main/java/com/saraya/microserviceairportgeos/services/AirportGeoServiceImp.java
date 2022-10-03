package com.saraya.microserviceairportgeos.services;

import com.saraya.microserviceairportgeos.exceptions.ResourceNotFoundException;
import com.saraya.microserviceairportgeos.models.AirportGeo;
import com.saraya.microserviceairportgeos.repositories.AirportGeoRepository;
import com.saraya.microserviceairportgeos.services.AirportGeoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirportGeoServiceImp implements AirportGeoService {
    private final AirportGeoRepository airportGeoRepository;

    public AirportGeoServiceImp(AirportGeoRepository airportGeoRepository) {
        this.airportGeoRepository = airportGeoRepository;
    }

    @Override
    public AirportGeo add(AirportGeo airportGeo) {
        return this.airportGeoRepository.save(airportGeo);
    }

    @Override
    public AirportGeo update(AirportGeo airportGeo) {
        return this.airportGeoRepository.save(airportGeo);
    }

    @Override
    public AirportGeo getAirportGeo(Long airportGeo_id) throws ResourceNotFoundException {
        Optional<AirportGeo> airportGeo = this.airportGeoRepository.findById(airportGeo_id);
        if (!airportGeo.isPresent())
            throw new ResourceNotFoundException("AirportGeo not available");
        return airportGeo.get();
    }

    @Override
    public Page<AirportGeo> getAirportGeos(Pageable pageable) {
        return this.airportGeoRepository.findAll(pageable);
    }

    @Override
    public void delete(Long airportGeo_id) throws ResourceNotFoundException {
      if (!this.existAirportGeo(airportGeo_id))
          throw new ResourceNotFoundException("impossible to remove this AirportGeo");

      this.airportGeoRepository.deleteById(airportGeo_id);
    }

    @Override
    public boolean existAirportGeo(Long airportGeo_id) {
        return this.airportGeoRepository.existsById(airportGeo_id);
    }
}
