package com.saraya.microservicetimetables.controllers;


import com.saraya.microservicetimetables.dto.TimeTableDto;
import com.saraya.microservicetimetables.exceptions.ResourceNotFoundException;
import com.saraya.microservicetimetables.mappers.TimeTableMapper;
import com.saraya.microservicetimetables.models.TimeTable;
import com.saraya.microservicetimetables.services.TimeTableService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/timeTables")
public class TimeTableController {
    private final TimeTableService timeTableService;
    private final TimeTableMapper timeTableMapper;

    public TimeTableController(TimeTableService timeTableService, TimeTableMapper timeTableMapper) {
        this.timeTableService = timeTableService;
        this.timeTableMapper = timeTableMapper;
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody TimeTableDto timeTableDto){

        TimeTable timeTable = timeTableService.add(timeTableMapper.timeTableDtoToTimeTable(timeTableDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(timeTableMapper.timeTableToTimeTableDto(timeTable));
    }
    @GetMapping
    public ResponseEntity<Map<String,Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        List<TimeTable> timeTableList = new ArrayList<>();
        Pageable pageable = PageRequest.of(page, size);
        Page<TimeTable> timeTablePage = this.timeTableService.getTimeTables(pageable);
        timeTableList = timeTablePage.getContent();
        Map<String,Object>  response = new HashMap<>();
        response.put("timeTables",this.timeTableMapper.timeTablesToTimeTableDtos(timeTableList));
        response.put("currentPage",timeTablePage.getNumber());
        response.put("totalItems",timeTablePage.getTotalElements());
        response.put("totalPages",timeTablePage.getTotalPages());

        if (timeTableList.isEmpty())
            return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<TimeTableDto> findById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id==null || id<1)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        TimeTable timeTable = this.timeTableService.getTimeTable(id);

        return new ResponseEntity<TimeTableDto>(this.timeTableMapper.timeTableToTimeTableDto(timeTable),HttpStatus.OK);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody TimeTableDto timeTableDto, @PathVariable Long id){
        if (id==null || id<1)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        TimeTable timeTable = timeTableService.update(timeTableMapper.timeTableDtoToTimeTable(timeTableDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(timeTableMapper.timeTableToTimeTableDto(timeTable));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id==null || id<1)
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
         this.timeTableService.delete(id);
         return ResponseEntity.noContent().build();
    }
}
