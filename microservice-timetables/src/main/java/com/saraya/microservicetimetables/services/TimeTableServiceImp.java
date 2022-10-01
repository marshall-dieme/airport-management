package com.saraya.microservicetimetables.services;

import com.saraya.microservicetimetables.exceptions.ResourceNotFoundException;
import com.saraya.microservicetimetables.models.TimeTable;
import com.saraya.microservicetimetables.repositories.TimeTableRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TimeTableServiceImp implements TimeTableService {
    private final TimeTableRepository timeTableRepository;

    public TimeTableServiceImp(TimeTableRepository timeTableRepository) {
        this.timeTableRepository = timeTableRepository;
    }

    @Override
    public TimeTable add(TimeTable timeTable) {
        return this.timeTableRepository.save(timeTable);
    }

    @Override
    public TimeTable update(TimeTable timeTable) {
        return this.timeTableRepository.save(timeTable);
    }

    @Override
    public TimeTable getTimeTable(Long timeTable_id) throws ResourceNotFoundException {
        Optional<TimeTable> timeTable = this.timeTableRepository.findById(timeTable_id);
        if (!timeTable.isPresent())
            throw new ResourceNotFoundException("TimeTable not available");
        return timeTable.get();
    }

    @Override
    public Page<TimeTable> getTimeTables(Pageable pageable) {
        return this.timeTableRepository.findAll(pageable);
    }

    @Override
    public void delete(Long timeTable_id) throws ResourceNotFoundException {
      if (!this.existTimeTable(timeTable_id))
          throw new ResourceNotFoundException("impossible to remove this TimeTable");

      this.timeTableRepository.deleteById(timeTable_id);
    }

    @Override
    public boolean existTimeTable(Long timeTable_id) {
        return this.timeTableRepository.existsById(timeTable_id);
    }
}
