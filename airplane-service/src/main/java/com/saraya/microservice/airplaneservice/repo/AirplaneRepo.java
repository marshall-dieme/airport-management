package com.saraya.microservice.airplaneservice.repo;


import com.saraya.microservice.airplaneservice.bean.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepo extends JpaRepository<Airplane, Integer> {
}
