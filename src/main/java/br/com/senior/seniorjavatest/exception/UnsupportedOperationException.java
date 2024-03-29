package br.com.senior.seniorjavatest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedOperationException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UnsupportedOperationException(String message) {
		super(message);
	}
	
}
