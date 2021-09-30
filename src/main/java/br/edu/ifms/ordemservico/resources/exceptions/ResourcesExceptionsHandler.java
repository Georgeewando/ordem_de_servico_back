package br.edu.ifms.ordemservico.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.edu.ifms.ordemservico.services.exceptions.DataBaseException;
import br.edu.ifms.ordemservico.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourcesExceptionsHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest Request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError error = new StandardError();
		error.setTimestemp(Instant.now());
		error.setStatus(status.value());
		error .setError("Resource not found");
		error.setMessage(e.getMessage());
		error.setPath(Request.getRequestURI());
		return ResponseEntity.status(status).body(error);
		
	}
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandardError> entityNotFound(DataBaseException e, HttpServletRequest Request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError error = new StandardError();
		error.setTimestemp(Instant.now());
		error.setStatus(status.value());
		error .setError("DataBase Exception");
		error.setMessage(e.getMessage());
		error.setPath(Request.getRequestURI());
		return ResponseEntity.status(status).body(error);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> entityNotFound(MethodArgumentNotValidException e, HttpServletRequest Request){
		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
		ValidationError error = new ValidationError();
		error.setTimestemp(Instant.now());
		error.setStatus(status.value());
		error .setError("Validation Exception");
		error.setMessage(e.getMessage());
		error.setPath(Request.getRequestURI());
		for(FieldError f : e.getBindingResult().getFieldErrors()) {
			error.addError(f.getField(), f.getDefaultMessage());;
		
		}
		return ResponseEntity.status(status).body(error);
	}
}
