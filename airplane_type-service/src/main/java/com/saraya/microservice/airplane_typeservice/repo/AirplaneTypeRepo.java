package com.saraya.microservice.airplane_typeservice.repo;


import com.saraya.microservice.airplane_typeservice.bean.AirplaneType;
//import com.saraya.microservice.airplaneservice.bean.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneTypeRepo extends JpaRepository<AirplaneType, Integer> {
}
