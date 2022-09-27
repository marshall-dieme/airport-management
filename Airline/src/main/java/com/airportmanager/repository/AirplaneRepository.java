package com.airportmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airportmanager.model.Airplane;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane,Long> {

}
