package com.saraya.Airport.dto;

import lombok.Data;

@Data
public class AirportAirlineDTO {
    
    private Long airport_id;
    private String airport_name;
    private String  iata;
}