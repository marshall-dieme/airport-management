package com.saraya.microservice.passengerDetailservice.repo;

import com.saraya.microservice.passengerDetailservice.bean.PassagerDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassagerDetailRepo extends JpaRepository<PassagerDetail, Integer> {
}
