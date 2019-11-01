package br.com.senior.seniorjavatest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class FileUploadErrorException  extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public FileUploadErrorException(String message) {
		super(message);
	}
	
}