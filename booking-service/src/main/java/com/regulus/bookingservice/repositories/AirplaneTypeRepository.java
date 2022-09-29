package com.regulus.airplanetypeservice.repositories;

import com.regulus.airplanetypeservice.models.AirplaneType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneTypeRepository extends JpaRepository<AirplaneType, Integer> {

    @Query("select a.airplane_type_id from AirplaneType a where a.airplane_type_identifier=:identifier")
    Integer findByAirplane_type_identifier(String identifier);
}
