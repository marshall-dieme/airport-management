package com.saraya.microservicetimetables.services;

import com.saraya.microservicetimetables.exceptions.ResourceNotFoundException;
import com.saraya.microservicetimetables.models.TimeTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface TimeTableService {

    TimeTable add(TimeTable timeTable);
    TimeTable update(TimeTable timeTable);
    TimeTable getTimeTable(Long timeTable_id) throws ResourceNotFoundException;
    Page<TimeTable> getTimeTables(Pageable pageable);
    void delete(Long timeTable_id) throws ResourceNotFoundException;
    boolean existTimeTable(Long timeTable_id);

}
