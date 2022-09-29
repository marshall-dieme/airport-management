package com.regulus.timetableservice.controllers;

import com.regulus.timetableservice.dtos.TimeTableDto;
import com.regulus.timetableservice.models.TimeTable;
import com.regulus.timetableservice.services.TimeTableService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timeTable")
public class TimeTableController {

    private final TimeTableService timeTableService;

    public TimeTableController(TimeTableService timeTableService) {
        this.timeTableService = timeTableService;
    }

    @GetMapping
    public List<TimeTable> getTimeTableList(){
        return timeTableService.getTimeTable();
    }

    @PostMapping
    public TimeTableDto create(@RequestBody TimeTableDto timeTableDto){
        return timeTableService.createTimeTable(timeTableDto);
    }

    @PutMapping("/{id}")
    public TimeTableDto update(@PathVariable("id") int id, @RequestBody TimeTableDto timeTableDto){
        return timeTableService.updateTimeTable(timeTableDto, id);
    }

    @GetMapping("/{id}")
    public TimeTableDto getTimeTable(@PathVariable("id") int id ){
        return timeTableService.getTimeTable(id);
    }
    

    @DeleteMapping("/{id}")
    public void deleteTimeTable(@PathVariable("id") int id){
        timeTableService.deleteTimeTable(id);
    }

}
