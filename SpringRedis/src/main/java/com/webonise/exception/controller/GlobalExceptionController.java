package com.webonise.exception.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.webonise.exception.EmptyFoundException;
import com.webonise.exception.FailedToUpdateDatabseException;
import com.webonise.exception.NotFoundException;

@ControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(value = NotFoundException.class)
	public ResponseEntity<Object> notFoundException(NotFoundException ex) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = EmptyFoundException.class)
	public ResponseEntity<Object> emptyFoundException(EmptyFoundException ex) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@ExceptionHandler(value = FailedToUpdateDatabseException.class)
	public ResponseEntity<Object> failedToUpdateDatabseException(FailedToUpdateDatabseException ex) {
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}
}
