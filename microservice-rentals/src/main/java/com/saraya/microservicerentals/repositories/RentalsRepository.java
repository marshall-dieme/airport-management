package com.saraya.microservicerentals.repositories;

import com.saraya.microservicerentals.models.Rentals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalsRepository extends JpaRepository<Rentals,Long> {
}
