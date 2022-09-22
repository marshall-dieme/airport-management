package com.saraya.airplaneservice.services;

import com.saraya.airplaneservice.exceptions.ResourceNotFoundException;
import com.saraya.airplaneservice.models.Airplane;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface AirplaneService {

    Airplane add(Airplane airplane);
    Airplane update(Airplane airplane);
    Airplane getAirplane(Long airplane_id) throws ResourceNotFoundException;
    Page<Airplane> getAirplanes(Pageable pageable);
    void delete(Long airplane_id) throws ResourceNotFoundException;
    boolean existAirplane(Long airplane_id);

}
