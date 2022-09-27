package com.saraya.Airportservice.consumer;

import com.saraya.Airportservice.bean.Airline;
import com.saraya.Airportservice.bean.Airport_Geo;
import com.saraya.Airportservice.bean.Services;
import com.saraya.Airportservice.model.Airport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAirportAndDetails {
    private Airport airport;
    private Airline airline;
    private Airport_Geo airport_geo;
    private Services services;
}
