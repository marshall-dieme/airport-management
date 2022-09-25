package com.saraya.TimeTable.mapper;

import org.springframework.stereotype.Component;

import com.saraya.TimeTable.dto.TimeTableDTO;
import com.saraya.TimeTable.model.TimeTable;

@Component
public class Mapper {
	public TimeTable toTimeTable(TimeTableDTO dto) {
		TimeTable timeTable = new TimeTable();
		timeTable.setAirline(dto.getAirline());
		timeTable.setFlight_from(dto.getFlight_from());
		timeTable.setFlight_to(dto.getFlight_to());
		timeTable.setFlight_type(dto.getFlight_type());
		return timeTable;
	}
	
	
	public TimeTableDTO toDTO(TimeTable timeTable) {
		TimeTableDTO timeTableDTO = new TimeTableDTO();
		timeTableDTO.setAirline(timeTable.getAirline());
		timeTableDTO.setFlight_from(timeTable.getFlight_from());
		timeTableDTO.setFlight_to(timeTable.getFlight_to());
		timeTableDTO.setFlight_type(timeTable.getFlight_type());
		return timeTableDTO;
	}
}
