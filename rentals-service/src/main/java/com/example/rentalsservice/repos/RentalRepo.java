package com.example.rentalsservice.repos;

import com.example.rentalsservice.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalRepo extends JpaRepository<Rental ,Long> {
    List <Rental> findByPassengerId(Long passengerId);
}
