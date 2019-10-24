package com.example.exception.test.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ParameterException extends RuntimeException {

    public ParameterException( ) {
        super();
    }

    public ParameterException(String message) {
        super(message);
    }
}
