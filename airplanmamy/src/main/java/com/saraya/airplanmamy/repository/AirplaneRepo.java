package com.saraya.airplanmamy.repository;

import com.saraya.airplanmamy.bean.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirplaneRepo extends JpaRepository<Airplane,Integer> {
    Airplane findByAirplaneId(int id);
}
