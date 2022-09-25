package com.saraya.TimeTable.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saraya.TimeTable.dto.TimeTableDTO;
import com.saraya.TimeTable.mapper.Mapper;
import com.saraya.TimeTable.model.TimeTable;
import com.saraya.TimeTable.repository.TimeTableRepository;
import com.saraya.TimeTable.services.TimeTableServices;
@Service
public class TimeTableServiceImpl implements TimeTableServices {
	@Autowired
	private TimeTableRepository repository;
	@Autowired
	private Mapper mapper;
	@Override
	public TimeTableDTO create(TimeTableDTO dto) {
		TimeTable table = mapper.toTimeTable(dto);		
		repository.save(table);
		TimeTableDTO timeTableDTO = mapper.toDTO(table);
		return timeTableDTO;
	}

	@Override
	public List<TimeTableDTO> getAllTimeTable() {
		List<TimeTable> tables = repository.findAll();
		List<TimeTableDTO> dtos = new ArrayList<>();
		for (TimeTable timeTable : tables) {
			TimeTableDTO dto = mapper.toDTO(timeTable);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public TimeTableDTO getTimeTable(Long id) {
		Optional<TimeTable> optional = repository.findById(id);
		TimeTableDTO dto = null;
		if (optional.isPresent()) {
			dto = mapper.toDTO(optional.get());
		}
		else {
			throw new RuntimeException("---------> ID not found !!!!");
		}
		return dto;
	}

	@Override
	public TimeTableDTO update(TimeTableDTO dto, Long id) {
		Optional<TimeTable> optional = repository.findById(id);
		TimeTableDTO tableDTO = null;
		if (optional.isPresent()) {
			TimeTable table = optional.get();
			table.setAirline(dto.getAirline());
			table.setFlight_from(dto.getFlight_from());
			table.setFlight_to(dto.getFlight_to());
			table.setFlight_type(dto.getFlight_type());
			tableDTO = mapper.toDTO(table);
		}
		return tableDTO;
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	
}
