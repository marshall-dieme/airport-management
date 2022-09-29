package com.saraya.flight.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FlightDto {

    private long flight_id;
    private String flight_no;
    private String departure_date;
    private String arrival_date;
    private String from;
    private String to;
}
