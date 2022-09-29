package com.saraya.Timetableservice.service;

import com.saraya.Timetableservice.dto.TimeTableDto;
import com.saraya.Timetableservice.model.TimeTable;

import java.util.List;

public interface TimeTableService {

    List<TimeTableDto> getTimeTables();

    TimeTableDto getTimeTable(Long timetable_id);

    TimeTable saveTimeTable(TimeTableDto dto);

    TimeTable updateTimeTable(TimeTableDto dto);

    void deleteTimeTable(Long timetable_id);


}
