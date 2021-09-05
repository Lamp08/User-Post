package com.rest.webservices.restfulwebservices.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotfoundException extends RuntimeException{

    public UserNotfoundException(String message) {
        super(message);
    }
}
