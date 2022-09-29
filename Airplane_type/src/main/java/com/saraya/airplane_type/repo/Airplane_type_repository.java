package com.saraya.airplane_type.repo;

import com.saraya.airplane_type.model.Airplane_type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Airplane_type_repository extends JpaRepository<Airplane_type, Long> {
    Airplane_type findById(long airplane_id);

}
