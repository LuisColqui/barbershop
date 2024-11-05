package com.example.barbershop.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import com.example.barbershop.dto.GenericResponse;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.web.bind.MethodArgumentNotValidException;

@RestControllerAdvice
public class GlobalErrorHandler {

     @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericResponse<CustomErrorResponse>> handleDefautlException(Exception ex, WebRequest request){

        CustomErrorResponse errorResponse = new CustomErrorResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(new GenericResponse<>(500, "failed", Arrays.asList(errorResponse)), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<GenericResponse<CustomErrorResponse>> handleModelNotFoundExException(ModelNotFoundException ex, WebRequest request){
        CustomErrorResponse errorResponse = new CustomErrorResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return  new ResponseEntity<>(new GenericResponse<>(404, "not-found", Arrays.asList(errorResponse)), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GenericResponse<CustomErrorResponse>> handleBadRequest(MethodArgumentNotValidException ex, WebRequest request) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(new GenericResponse<>(400, "bad-request", Arrays.asList(errorResponse)), HttpStatus.BAD_REQUEST);
    }



}
