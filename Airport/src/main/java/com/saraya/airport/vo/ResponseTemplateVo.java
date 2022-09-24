package com.saraya.airport.vo;


import com.saraya.airport.model.Airport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVo {

    private AirportGeo airportGeo;
    private Airport airport;
}

