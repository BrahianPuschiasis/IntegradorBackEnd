package com.ClinicaOdontologica.clinica.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        // Manejo de la excepción globalmente
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Se ha producido una excepción: " + e.getMessage());
    }
}
