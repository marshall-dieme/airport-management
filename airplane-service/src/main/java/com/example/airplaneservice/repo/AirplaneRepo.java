package com.example.airplaneservice.repo;

import com.example.airplaneservice.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AirplaneRepo extends JpaRepository<Airplane, Long> {
    List <Airplane> findByIdAirline(Long idAirline);

    List <Airplane> findByFlightId(Long flightId);

    List <Airplane> findByTypeId(Long airplaneTypeIdentifier);


}
