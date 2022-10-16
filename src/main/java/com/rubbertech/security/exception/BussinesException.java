package com.rubbertech.security.exception;

import java.time.LocalDate;

public class BussinesException extends RuntimeException{
	

	private static final long serialVersionUID = 1L;
	private LocalDate date;
	private String message;
	private String details;
	
	
	public BussinesException() {
		super();
	}


	public BussinesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);	
	}


	public BussinesException(String message, Throwable cause) {
		super(message, cause);	
	}


	public BussinesException(String message) {
		super(message);	
	}


	public BussinesException(Throwable cause) {
		super(cause);
	}


	public BussinesException(LocalDate date, String message, String details) {
		super();
		this.date = date;
		this.message = message;
		this.details = details;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

}
