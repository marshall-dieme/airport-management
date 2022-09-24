package com.saraya.airplane.repo;

import com.saraya.airplane.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Long> {

    Airplane findById(long airplane_id);
}
