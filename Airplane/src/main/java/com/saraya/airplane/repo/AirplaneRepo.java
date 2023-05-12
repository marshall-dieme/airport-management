package com.saraya.airplane.repo;

import com.saraya.airplane.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirplaneRepo extends JpaRepository<Airplane,Long> {

    @Query("select a.airplane_id from Airplane a where a.capacity=:capacity")
    Long getIdAirplane(String capacity);

    List<Airplane> findByIdAirline(Long IdAirline);
}
