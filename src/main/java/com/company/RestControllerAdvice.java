package com.company;

import org.springframework.beans.NotWritablePropertyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;
import java.util.NoSuchElementException;

@ControllerAdvice
class RestControllerAdvice {

//    @ExceptionHandler(CustomException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public CustomException handleCustomException(CustomException ce) {
//        return ce;
//    }

//    // w/o this - 500
//    @ExceptionHandler(ConstraintViolationException.class)
//    //@ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
//        return new ResponseEntity<>("Nnnot valid: " + e.getMessage(), HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
//    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
//    @ResponseBody
//    String handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
//        return "MMmethodArgumentTypeMismatchException: " + e.getMessage();
//    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>("handleException: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    //@ResponseBody
    void handleNoSuchElementException(NoSuchElementException e) {
        //return "NoSuchElementException: " + e.getMessage();
    }

    @ExceptionHandler(HttpMessageNotWritableException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    void handleHttpMessageNotWritableException(HttpMessageNotWritableException e) {
    }

}

