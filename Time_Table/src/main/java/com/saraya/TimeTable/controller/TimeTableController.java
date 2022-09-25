package com.saraya.TimeTable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saraya.TimeTable.dto.TimeTableDTO;
import com.saraya.TimeTable.services.TimeTableServices;



@RestController
@RequestMapping("/timetables")
public class TimeTableController {
	@Autowired
	private TimeTableServices services;
	@PostMapping("/")
	public TimeTableDTO create(@RequestBody TimeTableDTO dto) {
		return services.create(dto);
	}
	
	@GetMapping("/list")
	public List<TimeTableDTO> retrieve() {
		return services.getAllTimeTable();
	}
	
	@GetMapping("/{id}")
	public TimeTableDTO create(@PathVariable Long id) {
		return services.getTimeTable(id);
	}
	
	@PutMapping("/update/{id}")
	public TimeTableDTO update(@RequestBody TimeTableDTO dto, @PathVariable Long id) {
		return services.update(dto, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		services.delete(id);
	}
}
