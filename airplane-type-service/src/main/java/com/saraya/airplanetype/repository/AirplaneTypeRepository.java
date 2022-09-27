package com.saraya.airplanetype.repository;

import com.saraya.airplanetype.model.AirplaneType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneTypeRepository extends JpaRepository<AirplaneType, Long> {

}
