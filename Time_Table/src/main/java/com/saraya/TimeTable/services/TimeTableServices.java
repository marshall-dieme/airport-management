package com.saraya.TimeTable.services;

import java.util.List;

import com.saraya.TimeTable.dto.TimeTableDTO;



public interface TimeTableServices {
	TimeTableDTO create(TimeTableDTO dto);
	List<TimeTableDTO> getAllTimeTable();
	TimeTableDTO getTimeTable(Long id);
	TimeTableDTO update(TimeTableDTO dto, Long id);
	void delete(Long id);
}
