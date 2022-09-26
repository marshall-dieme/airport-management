package com.saraya.airplane_type.repository;

import com.saraya.airplane_type.model.Airplane_type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Airplane_typeRepo extends JpaRepository<Airplane_type, Long> {
}
