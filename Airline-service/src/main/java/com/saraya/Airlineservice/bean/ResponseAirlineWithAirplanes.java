package com.saraya.Airlineservice.bean;

import com.saraya.Airlineservice.model.Airline;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAirlineWithAirplanes {
    private Airplane airplane;
    private Airline airline;
}
