package com.sundarland.game.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ApiKeyException extends RuntimeException{


    public ApiKeyException(String message){
        super(message);


    }



}
