package com.vlm.timetable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vlm.timetable.model.Time;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {

}
