package com.app.crm.myapp.Exception;

import java.util.Date;

public class ExceptionResponse {

	private int status;
	
	private String message;
	
	private Date timestamp;

	public ExceptionResponse() {}
	
	public ExceptionResponse(int status, String message, Date timestamp) {
		super();
		this.status = status;
		this.message = message;
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
}
