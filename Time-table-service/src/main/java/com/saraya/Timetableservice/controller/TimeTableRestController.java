package com.saraya.Timetableservice.controller;

import com.saraya.Timetableservice.dto.TimeTableDto;
import com.saraya.Timetableservice.model.TimeTable;
import com.saraya.Timetableservice.service.TimeTableServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("times-table")
public class TimeTableRestController {

    private final TimeTableServiceImpl timeTableService;


    @GetMapping
    public ResponseEntity<List<TimeTableDto>> getAllTimeTable() {
        return ResponseEntity.ok(timeTableService.getTimeTables());
    }

    @GetMapping("/{timetable_id}")
    public ResponseEntity<TimeTableDto> getTimeTable(@PathVariable Long timetable_id) {
        return ResponseEntity.ok(timeTableService.getTimeTable(timetable_id));
    }

    @PostMapping
    public ResponseEntity<TimeTable> saveTimeTable(@RequestBody TimeTableDto dto) {
        return new ResponseEntity<>(timeTableService.saveTimeTable(dto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TimeTable> updateTimeTable(@RequestBody TimeTableDto dto) {
        return  ResponseEntity.ok(timeTableService.updateTimeTable(dto));
    }

    @DeleteMapping("/{timetable_id}")
    public ResponseEntity<String> deleteTimeTable(@PathVariable Long timetable_id) {
        timeTableService.deleteTimeTable(timetable_id);
        return ResponseEntity.ok("Time Table "+timetable_id+" was deleted successfully");
    }


}
