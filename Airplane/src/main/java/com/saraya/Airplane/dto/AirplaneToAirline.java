package com.saraya.Airplane.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class AirplaneToAirline {

    private Long airplane_id;
    private String  capacity;
    private String iata;
    private String airline_name;
}