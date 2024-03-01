package com.saraya.timetableservice.mapper;

import com.saraya.timetableservice.bean.TimeTable;
import com.saraya.timetableservice.dto.TimeTableDto;

public class TimeTableMapper {

    public TimeTable toEntity(TimeTableDto dto){
        TimeTable timeTable = new TimeTable();
        timeTable.setAirline(dto.getAirline());
        timeTable.setFlightFrom(dto.getFlightFrom());
        timeTable.setFlightTo(dto.getFlightTo());
        timeTable.setFlightType(dto.getFlightType());
        return timeTable;
    }

    public TimeTableDto toDto(TimeTable timeTable){
        TimeTableDto dto = new TimeTableDto();
        dto.setAirline(timeTable.getAirline());
        dto.setFlightFrom(timeTable.getFlightFrom());
        dto.setFlightTo(timeTable.getFlightTo());
        dto.setFlightType(timeTable.getFlightType());
        return dto;
    }
}
