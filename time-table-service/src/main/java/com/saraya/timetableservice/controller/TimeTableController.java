package com.saraya.timetableservice.controller;

import com.saraya.timetableservice.bean.TimeTable;
import com.saraya.timetableservice.dto.TimeTableDto;
import com.saraya.timetableservice.service.TimeTableService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/TimeTable")
public class TimeTableController {

    private final TimeTableService service;

    public TimeTableController(TimeTableService service) {
        this.service = service;
    }

    @GetMapping
    public List<TimeTable> getAll(){
        return service.getAll();
    }

    @PostMapping
    public TimeTable create(@RequestBody TimeTableDto dto){
        return service.create(dto);
    }

    @GetMapping("/{airline}")
    public int getId(@PathVariable("airline") String airline){
        return service.getId(airline);
    }

    @PostMapping("flight/{timeTableId}/{flightNo}")
    public String putFlightForTimeTable(@PathVariable("timeTableId") int timeTableId,
                                        @PathVariable("flightNo") String flightNo){
        return service.putFlightForTimeTable(timeTableId, flightNo);
    }
}
