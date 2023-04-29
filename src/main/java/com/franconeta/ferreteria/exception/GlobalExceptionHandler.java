package com.franconeta.ferreteria.exception;

import com.franconeta.ferreteria.dto.APIExceptionResponse;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
     @ExceptionHandler(EntityExistsException.class)
     protected ResponseEntity<?> handleEntityExistsException(EntityExistsException ex, WebRequest request) {
          return new ResponseEntity<>(APIExceptionResponse.builder()
                  .timestamp(LocalDateTime.now())
                  .status(HttpStatus.BAD_REQUEST.value())
                  .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                  .message(ex.getMessage())
                  .build(), HttpStatus.BAD_REQUEST);
     }

     @ExceptionHandler(EntityNotFoundException.class)
     protected ResponseEntity<?> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request) {
          return new ResponseEntity<>(APIExceptionResponse.builder()
                  .timestamp(LocalDateTime.now())
                  .status(HttpStatus.NOT_FOUND.value())
                  .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                  .message(ex.getMessage())
                  .build(), HttpStatus.NOT_FOUND);
     }
}