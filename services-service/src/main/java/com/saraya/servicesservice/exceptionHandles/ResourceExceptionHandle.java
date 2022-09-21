package com.saraya.servicesservice.exceptionHandles;

import com.saraya.servicesservice.models.ErrorMessage;
import com.saraya.servicesservice.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class ResourceExceptionHandle extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> employeeNotFound(ResourceNotFoundException exception, WebRequest request){

        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND, exception.getMessage(), request.getContextPath());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}
