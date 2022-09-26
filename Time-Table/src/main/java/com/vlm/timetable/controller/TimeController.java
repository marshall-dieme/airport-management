package com.vlm.timetable.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vlm.timetable.exception.ResourceNotFoundException;
import com.vlm.timetable.model.Time;
import com.vlm.timetable.repository.TimeRepository;

@RestController
@RequestMapping("/api/")
public class TimeController {
	
	@Autowired
	private TimeRepository timeRepository;
	
	@GetMapping("/tables")
	public List<Time> getAllTables(){
		return timeRepository.findAll();
	}
	
	@PostMapping("/tables")
	public Time createTime(@RequestBody Time time) {
		return timeRepository.save(time);
	}
	
	@GetMapping("/tables/{id}")
	public ResponseEntity<Time> getTimeById(@PathVariable Long id){
		Time time = timeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Time not exist with id :" + id));
		return ResponseEntity.ok(time);
	}
	

	@PutMapping("/tabless/{id}")
	public ResponseEntity<Time> updateTime(@PathVariable Long id, @RequestBody Time timeDetails){
		Time time = timeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Time not exist with id :" + id));
		
		time.setFlight_from(timeDetails.getFlight_from());
		time.setFlight_to(timeDetails.getFlight_to());
		time.setAirline(timeDetails.getAirline());
		time.setFlight_type(timeDetails.getFlight_type());
		
		Time updatedTime = timeRepository.save(time);
		return ResponseEntity.ok(updatedTime);
	}
	
	@DeleteMapping("/tables/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteTime(@PathVariable Long id){
		Time time = timeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Time not exist with id :" + id));
		
		timeRepository.delete(time);
		Map<String, Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
