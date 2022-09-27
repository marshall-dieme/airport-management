package com.saraya.rentalsservice.repository;

import com.saraya.rentalsservice.bean.Rentals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalsRepo extends JpaRepository<Rentals, Integer> {
    Rentals findByName(String name);
}
