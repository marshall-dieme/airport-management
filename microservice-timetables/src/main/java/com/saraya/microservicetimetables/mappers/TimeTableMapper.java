package com.saraya.microservicetimetables.mappers;

import com.saraya.microservicetimetables.dto.TimeTableDto;
import com.saraya.microservicetimetables.models.TimeTable;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TimeTableMapper {
    TimeTable timeTableDtoToTimeTable(TimeTableDto timeTableDto);

    TimeTableDto timeTableToTimeTableDto(TimeTable timeTable);

    List<TimeTableDto> timeTablesToTimeTableDtos(List<TimeTable> timeTables);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TimeTable updateTimeTableFromTimeTableDto(TimeTableDto timeTableDto, @MappingTarget TimeTable timeTable);
}
