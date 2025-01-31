package ru.dorogov.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserDoesNotExistException extends RuntimeException{
    public UserDoesNotExistException(Long id){
        super("User " + id + " does not exist.");
    }
}