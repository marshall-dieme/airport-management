package com.saraya.Timetableservice.service;

import com.saraya.Timetableservice.dto.TimeTableDto;
import com.saraya.Timetableservice.model.TimeTable;
import com.saraya.Timetableservice.repository.TimeTableRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TimeTableServiceImpl implements TimeTableService{

    private final TimeTableRepository timeTableRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<TimeTableDto> getTimeTables() {
        return timeTableRepository.findAll().stream().map(timeTable ->
                modelMapper.map(timeTable, TimeTableDto.class)).toList();
    }

    @Override
    public TimeTableDto getTimeTable(Long timetable_id) {
        TimeTable timeTable = timeTableRepository.findById(timetable_id).orElseThrow();
        return modelMapper.map(timeTable, TimeTableDto.class);
    }

    @Override
    public TimeTable saveTimeTable(TimeTableDto dto) {
        TimeTable timeTable = modelMapper.map(dto, TimeTable.class);
        return timeTableRepository.save(timeTable);
    }

    @Override
    public TimeTable updateTimeTable(TimeTableDto dto) {
        return modelMapper.map(dto, TimeTable.class);
    }

    @Override
    public void deleteTimeTable(Long timetable_id) {
        timeTableRepository.deleteById(timetable_id);
    }
}
