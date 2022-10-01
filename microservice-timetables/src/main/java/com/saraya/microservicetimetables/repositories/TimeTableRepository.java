package com.saraya.microservicetimetables.repositories;

import com.saraya.microservicetimetables.models.TimeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeTableRepository extends JpaRepository<TimeTable,Long> {
}
