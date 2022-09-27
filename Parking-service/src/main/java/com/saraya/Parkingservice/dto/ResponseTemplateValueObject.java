package com.saraya.Parkingservice.dto;

import com.saraya.Parkingservice.model.Parking;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateValueObject {
    private Parking parking;
    private PassengerDto passengerDto;
}
