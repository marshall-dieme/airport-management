package com.example.ivo.exception2;

import java.util.Date;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data 
@NoArgsConstructor
@AllArgsConstructor 
 @ToString
public class ErrorDetails {
	private Date timestamp;
	 private String message;
	 private String details;

}
