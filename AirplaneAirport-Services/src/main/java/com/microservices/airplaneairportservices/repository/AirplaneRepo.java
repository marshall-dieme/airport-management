package com.microservices.airplaneairportservices.repository;


import com.microservices.airplaneairportservices.entity.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AirplaneRepo extends JpaRepository<Airplane, Long> {

    @Override
    Optional<Airplane> findById(Long airplane_id);

    List<Airplane> findByIdAirline(String idAirline);



}
