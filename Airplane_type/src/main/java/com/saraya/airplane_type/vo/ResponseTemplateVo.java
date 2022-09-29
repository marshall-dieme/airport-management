package com.saraya.airplane_type.vo;

import com.saraya.airplane_type.model.Airplane_type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseTemplateVo {
  private  Airplane airplane;
  private Airplane_type airplane_type;
}
