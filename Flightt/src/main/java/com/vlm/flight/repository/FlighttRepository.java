package com.vlm.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vlm.flight.model.Flightt;

@Repository
public interface FlighttRepository extends JpaRepository<Flightt, Integer> {

}
