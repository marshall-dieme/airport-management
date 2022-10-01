package com.saraya.microserviceairplanetypes.repositories;

import com.saraya.microserviceairplanetypes.models.AirplaneType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneTypeRepository extends JpaRepository<AirplaneType,Long> {
}
