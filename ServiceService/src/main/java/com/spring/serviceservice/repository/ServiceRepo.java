package com.spring.serviceservice.repository;


import com.spring.serviceservice.bean.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepo extends JpaRepository<Services, Integer> {
    //Services findById(int id);
    List<Services> findByAirportId(int airportId);

    public String findByName(String name);

}
