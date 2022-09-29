package com.regulus.timetableservice.services;

import com.regulus.timetableservice.dtos.TimeTableDto;
import com.regulus.timetableservice.models.TimeTable;
import com.regulus.timetableservice.repositories.TimeTableRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TimeTableService {

    private final TimeTableRepository repository;

    private final RestTemplate restTemplate;

    private final Mapper mapper;

    public TimeTableService(TimeTableRepository repository, RestTemplate restTemplate, Mapper mapper) {
        this.repository = repository;
        this.restTemplate = restTemplate;
        this.mapper = mapper;
    }

    public List<TimeTable> getTimeTable(){
        return repository.findAll();
    }

    public TimeTableDto getTimeTable(int id){
        TimeTable timeTable =  repository.findById(id).get();
        return mapper.toDto(timeTable);
    }

    public TimeTableDto createTimeTable(TimeTableDto timeTableDto){
        Integer flightId = restTemplate.getForEntity("http://flight-service/flight//flightNo/" + timeTableDto.getFlight_no(),
                Integer.class).getBody();
        assert  flightId != null;
        TimeTable timeTable = mapper.toEntity(timeTableDto);
        timeTable =  repository.save(timeTable);
        Map<String, Integer> values = new HashMap<>();
        values.put("timeTableId", timeTable.getTime_table_id());
        values.put("flightId", flightId);
        restTemplate.getForEntity("http://flight-timetable-relation/flightTimeTable/{flightId}/{timeTableId}",
                Void.class, values);
        return mapper.toDto(timeTable);
    }

    public TimeTableDto updateTimeTable(TimeTableDto timeTableDto, int id){
        TimeTableDto timeTableDto1 = getTimeTable(id);
        TimeTable timeTable = mapper.toEntity(timeTableDto1);
        timeTable.setTime_table_id(timeTableDto.getTime_table_id());
        timeTable.setFlight_from(timeTableDto.getFlight_from());
        timeTable.setFlight_to(timeTableDto.getFlight_to());
        timeTable.setAirline(timeTableDto.getAirline());
        timeTable.setFlight_type(timeTableDto.getFlight_type());
        timeTable = repository.save(timeTable);
        return mapper.toDto(timeTable);
    }

    public void deleteTimeTable(int id){
        TimeTableDto timeTableDto = getTimeTable(id);
        TimeTable timeTable = mapper.toEntity(timeTableDto);
        repository.delete(timeTable);
    }

}
