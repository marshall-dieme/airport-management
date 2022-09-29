package com.saraya.microserviceairplanes.servicesImpl;

import com.saraya.microserviceairplanes.exceptions.ResourceNotFoundException;
import com.saraya.microserviceairplanes.models.Airplane;
import com.saraya.microserviceairplanes.repositories.AirplaneRepository;
import com.saraya.microserviceairplanes.services.AirplaneService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirplaneServiceImp implements AirplaneService {
    private final AirplaneRepository airplaneRepository;

    public AirplaneServiceImp(AirplaneRepository airplaneRepository) {
        this.airplaneRepository = airplaneRepository;
    }


    @Override
    public Airplane add(Airplane airplane) {
        return this.airplaneRepository.save(airplane);
    }

    @Override
    public Airplane update(Airplane airplane) {
        return this.airplaneRepository.save(airplane);
    }

    @Override
    public Airplane getAirplane(Long airplane_id) throws ResourceNotFoundException {
        Optional<Airplane> airplane = this.airplaneRepository.findById(airplane_id);
        if (!airplane.isPresent())
            throw new ResourceNotFoundException("Airplane not available");
        return airplane.get();
    }

    @Override
    public Page<Airplane> getAirplanes(Pageable pageable) {
        return this.airplaneRepository.findAll(pageable);
    }

    @Override
    public void delete(Long airplane_id) throws ResourceNotFoundException {
      if (!this.existAirplane(airplane_id))
          throw new ResourceNotFoundException("impossible to remove this Airplane");

      this.airplaneRepository.deleteById(airplane_id);
    }

    @Override
    public boolean existAirplane(Long airplane_id) {
        return this.airplaneRepository.existsById(airplane_id);
    }
}
