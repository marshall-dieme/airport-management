package com.saraya.microserviceairplanetypes.services;

import com.saraya.microserviceairplanetypes.exceptions.ResourceNotFoundException;
import com.saraya.microserviceairplanetypes.models.AirplaneType;
import com.saraya.microserviceairplanetypes.repositories.AirplaneTypeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirplaneTypeServiceImp implements AirplaneTypeService {
    private final AirplaneTypeRepository airplaneTypeRepository;

    public AirplaneTypeServiceImp(AirplaneTypeRepository airplaneTypeRepository) {
        this.airplaneTypeRepository = airplaneTypeRepository;
    }

    @Override
    public AirplaneType add(AirplaneType airplaneType) {
        return this.airplaneTypeRepository.save(airplaneType);
    }

    @Override
    public AirplaneType update(AirplaneType airplaneType) {
        return this.airplaneTypeRepository.save(airplaneType);
    }

    @Override
    public AirplaneType getAirplaneType(Long airplaneType_id) throws ResourceNotFoundException {
        Optional<AirplaneType> airplaneType = this.airplaneTypeRepository.findById(airplaneType_id);
        if (!airplaneType.isPresent())
            throw new ResourceNotFoundException("AirplaneType not available");
        return airplaneType.get();
    }

    @Override
    public Page<AirplaneType> getAirplaneTypes(Pageable pageable) {
        return this.airplaneTypeRepository.findAll(pageable);
    }

    @Override
    public void delete(Long airplaneType_id) throws ResourceNotFoundException {
      if (!this.existAirplaneType(airplaneType_id))
          throw new ResourceNotFoundException("impossible to remove this AirplaneType");

      this.airplaneTypeRepository.deleteById(airplaneType_id);
    }

    @Override
    public boolean existAirplaneType(Long airplaneType_id) {
        return this.airplaneTypeRepository.existsById(airplaneType_id);
    }
}
