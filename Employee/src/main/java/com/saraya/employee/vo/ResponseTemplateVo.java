package com.saraya.employee.vo;

import com.saraya.employee.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseTemplateVo {

    private Employee employee;
    private ModelService modelService;


}
