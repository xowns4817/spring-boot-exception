package com.example.exception.test.demo.error;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ErrorResponse {

    private long timeStamp;
    private int statusCode;
    private String error;
    private String message;
}
