package com.nazareno.battleoftheelements.controller;

import com.nazareno.battleoftheelements.exception.CharacterNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CharacterRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CharacterErrorResponse> handleException (CharacterNotFoundException exc) {
        CharacterErrorResponse error = new CharacterErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CharacterErrorResponse> handleException (Exception exc) {
        CharacterErrorResponse error = new CharacterErrorResponse();

        exc.printStackTrace();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
