package com.saraya.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saraya.airport.entity.AirportEntity;

public interface AirportRepo extends JpaRepository<AirportEntity, Long> {

}
