package com.saraya.Bookingservice.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Passenger {
    private Long passenger_id;
    private String passport_no;
    private String firstname;
    private String lastname;
}
