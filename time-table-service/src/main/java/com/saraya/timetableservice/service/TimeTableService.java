package com.saraya.timetableservice.service;

import com.saraya.timetableservice.bean.TimeTable;
import com.saraya.timetableservice.dto.TimeTableDto;
import com.saraya.timetableservice.mapper.TimeTableMapper;
import com.saraya.timetableservice.repository.TimeTableRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TimeTableService {

    private final TimeTableRepo repo;

    public TimeTableService(TimeTableRepo repo) {
        this.repo = repo;
    }

    public TimeTableMapper mapper = new TimeTableMapper();

    public List<TimeTable> getAll() {
        return repo.findAll();
    }

    public TimeTable create(TimeTableDto dto) {
        return repo.save(mapper.toEntity(dto));
    }

    public int getId(String airline) {
        return repo.findByAirline(airline).getId();
    }

    public String putFlightForTimeTable(int timeTableId, String flightNo) {

        RestTemplate restTemplate = new RestTemplate();
        int flightId = restTemplate.getForEntity("http://localhost:8009/Flight/"+flightNo,
                Integer.class).getBody();

        Map<String, Integer> urlValues = new HashMap<>();
        urlValues.put("timeTableId", timeTableId);
        urlValues.put("flightId", flightId);
        new RestTemplate().getForEntity("http://localhost:8025/Relation2/{timeTableId}/{flightId}", void.class, urlValues).getBody();

        return "add succefull";
    }
}
