package com.saraya.airport.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Airline {

    private long airline_id;
    private String airline_name;
    private String iata;
}
