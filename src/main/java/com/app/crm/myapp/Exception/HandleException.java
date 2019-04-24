package com.app.crm.myapp.Exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandleException extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(CustomizedException.class)
	public ResponseEntity<ExceptionResponse> notFoundExceptionHandler(Exception e){
		
		ExceptionResponse ex=new ExceptionResponse();
		
		ex.setMessage(e.getMessage());
		ex.setStatus(HttpStatus.NOT_FOUND.value());
		ex.setTimestamp(new Date());
		
		return new ResponseEntity<ExceptionResponse>(ex,HttpStatus.NOT_FOUND);
	}
	
	

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> handleAllException(Exception e){
		
		ExceptionResponse ex=new ExceptionResponse();
		
		ex.setMessage(e.getMessage());
		ex.setStatus(HttpStatus.NOT_FOUND.value());
		ex.setTimestamp(new Date());
		
		return new ResponseEntity<ExceptionResponse>(ex,HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	
		ExceptionResponse ee=new ExceptionResponse();
		
		ee.setMessage("Validation failed : " + "First name and email cannot be null and must be greater than two in size");
		ee.setStatus(HttpStatus.NOT_FOUND.value());
		ee.setTimestamp(new Date());
		
		return new ResponseEntity<>(ee,HttpStatus.BAD_REQUEST);
	}

	


}
