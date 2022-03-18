package com.company.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
class RestControllerAdvice {

//    @ExceptionHandler(CustomException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public CustomException handleCustomException(CustomException ce) {
//        return ce;
//    }

    // w/o this - 500
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        return new ResponseEntity<>("Nnnot valid: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

