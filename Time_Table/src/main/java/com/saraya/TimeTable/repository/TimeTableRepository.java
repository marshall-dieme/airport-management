package com.saraya.TimeTable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saraya.TimeTable.model.TimeTable;
@Repository
public interface TimeTableRepository extends JpaRepository<TimeTable, Long> {

}
