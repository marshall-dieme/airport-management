package com.saraya.microserviceairplanes.repositories;


import com.saraya.microserviceairplanes.models.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane,Long> {
}
