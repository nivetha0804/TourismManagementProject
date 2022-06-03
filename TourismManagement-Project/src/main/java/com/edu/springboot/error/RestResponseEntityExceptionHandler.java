package com.edu.springboot.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.edu.springboot.entity.ErrorMessage;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(AdminNotFoundException.class)
	public ResponseEntity<ErrorMessage> AdminNotFoundException(AdminNotFoundException exception,WebRequest request) 
	{
		ErrorMessage message=new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());//constructor
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
	}
	@ExceptionHandler(VisitorNotFoundException.class)
	public ResponseEntity<ErrorMessage> VisitorNotFoundException(VisitorNotFoundException exception,WebRequest request) 
	{
		ErrorMessage message=new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());//constructor
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
	}
}
