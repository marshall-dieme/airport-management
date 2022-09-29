package com.saraya.Timetableservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * A DTO for the {@link com.saraya.Timetableservice.model.TimeTable} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TimeTableDto implements Serializable {
    private Long time_table_id;
    private String flight_from;
    private String flight_to;
    private String airline;
    private String flight_type;
}