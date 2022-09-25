package com.saraya.AirplaneType.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saraya.AirplaneType.model.AirplaneType;
@Repository
public interface AirplaneTypeRepository extends JpaRepository<AirplaneType, Long> {

}
