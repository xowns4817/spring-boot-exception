package com.example.exception.test.demo.handler;

import com.example.exception.test.demo.error.ErrorResponse;
import com.example.exception.test.demo.exception.ParameterException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ParameterException.class)
    protected ResponseEntity<ErrorResponse> handlerParam(ParameterException ex) {
        ErrorResponse errorResponse = getErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);

    }

    private ErrorResponse getErrorResponse(HttpStatus httpStatus, String message) {
        return ErrorResponse.builder()
                .timeStamp(makeTimeStamp())
                .statusCode(httpStatus.value())
                .error(httpStatus.getReasonPhrase())
                .message(message)
                .build();
    }

    private long makeTimeStamp() {
        return new Date().getTime();
    }
}
