package com.airportmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFindException   extends RuntimeException{
	private static final long serialVersionUID=1L;
	public ResourceNotFindException(String message) {
		super(message);
	}

}
