package com.codigolautaro.app.movies.controllers;

import com.codigolautaro.app.movies.exceptions.RequestException;
import com.codigolautaro.app.movies.models.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ErrorDTO> runTimeExceptionHandler(RuntimeException e)
    {
        ErrorDTO error = ErrorDTO.builder().message(e.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = RequestException.class)
    public ResponseEntity<ErrorDTO> requestExceptionHandler(RequestException e)
    {
        ErrorDTO error = ErrorDTO.builder().message(e.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
