package com.sundarland.game.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.WebResult;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler {
    @ExceptionHandler
    public final ResponseEntity<Object> handleApiKeyException (ApiKeyException ex, WebResult request) {
        ApiKeyExceptionResponse apiKeyExceptionResponse = new ApiKeyExceptionResponse(ex.getMessage());
        return new ResponseEntity(apiKeyExceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
