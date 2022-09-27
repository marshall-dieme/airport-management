package com.saraya.Airplane_Typeservice.consumer;

import com.saraya.Airplane_Typeservice.bean.Airplane;
import com.saraya.Airplane_Typeservice.model.Airplane_Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAirplaneAndAirplaneType {
    private Airplane_Type airplane_type;
    private Airplane airplane;
}
