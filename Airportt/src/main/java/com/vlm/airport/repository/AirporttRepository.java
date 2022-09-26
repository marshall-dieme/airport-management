package com.vlm.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vlm.airport.model.Airportt;

@Repository
public interface AirporttRepository extends JpaRepository<Airportt, Long> {

}
