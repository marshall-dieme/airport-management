package com.saraya.airplane.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Airline {

    private long airline_id;
    private String airline_name;
    private String iata;
    private long airport_id;
}
