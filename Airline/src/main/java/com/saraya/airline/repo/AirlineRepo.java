package com.saraya.airline.repo;

import com.saraya.airline.model.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Repository
public interface AirlineRepo  extends JpaRepository<Airline,Long> {

    @Query("SELECT ai.airline_id from Airline  ai WHERE ai.airline_name=:airline_name ")
    Long getIdAirline(String airline_name);


}
