package com.saraya.microserviceairplanetypes.services;

import com.saraya.microserviceairplanetypes.exceptions.ResourceNotFoundException;
import com.saraya.microserviceairplanetypes.models.AirplaneType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface AirplaneTypeService {

    AirplaneType add(AirplaneType airplaneType);
    AirplaneType update(AirplaneType airplaneType);
    AirplaneType getAirplaneType(Long airplaneType_id) throws ResourceNotFoundException;
    Page<AirplaneType> getAirplaneTypes(Pageable pageable);
    void delete(Long airplaneType_id) throws ResourceNotFoundException;
    boolean existAirplaneType(Long airplaneType_id);

}
