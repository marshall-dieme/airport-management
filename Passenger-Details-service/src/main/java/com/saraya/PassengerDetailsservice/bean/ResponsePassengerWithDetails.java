package com.saraya.PassengerDetailsservice.bean;

import com.saraya.PassengerDetailsservice.model.PassengerDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponsePassengerWithDetails {
    private Passenger passenger;
    private PassengerDetails passengerDetails;
}
