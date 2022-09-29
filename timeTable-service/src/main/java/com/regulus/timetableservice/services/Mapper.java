package com.regulus.timetableservice.services;

import com.regulus.timetableservice.dtos.TimeTableDto;
import com.regulus.timetableservice.models.TimeTable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class Mapper {

    public TimeTableDto toDto(TimeTable timeTable){
        TimeTableDto dto = new TimeTableDto();
        dto.setTime_table_id(timeTable.getTime_table_id());
        dto.setFlight_from(timeTable.getFlight_from());
        dto.setFlight_to(timeTable.getFlight_to());
        dto.setAirline(timeTable.getAirline());
        dto.setFlight_type(timeTable.getFlight_type());
        return dto;
    }

    public TimeTable toEntity(TimeTableDto dto){
        TimeTable timeTable = new TimeTable();
        timeTable.setTime_table_id(dto.getTime_table_id());
        timeTable.setFlight_from(dto.getFlight_from());
        timeTable.setFlight_to(dto.getFlight_to());
        timeTable.setAirline(dto.getAirline());
        timeTable.setFlight_type(dto.getFlight_type());
        return timeTable;
    }

}
