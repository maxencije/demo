package com.example.demo.APIExceptionHandler;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@RequiredArgsConstructor
public class APIException extends Throwable {
    private final String message;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestamp;
}