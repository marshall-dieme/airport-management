package com.saraya.timetableservice.repository;

import com.saraya.timetableservice.bean.TimeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeTableRepo extends JpaRepository<TimeTable, Integer> {
    TimeTable findByAirline(String airline);
}
