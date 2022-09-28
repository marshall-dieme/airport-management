package com.saraya.Rentalsservice.repository;

import com.saraya.Rentalsservice.model.Rentals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends JpaRepository<Rentals, Long> {
}
