package com.saraya.Airplane_Typeservice.repository;

import com.saraya.Airplane_Typeservice.model.Airplane_Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Airplane_TypeRepository extends JpaRepository<Airplane_Type, Long> {
}
