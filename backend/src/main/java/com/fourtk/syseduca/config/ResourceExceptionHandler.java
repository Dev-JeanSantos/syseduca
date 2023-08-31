package com.fourtk.syseduca.config;

import com.fourtk.syseduca.services.exceptions.DataBaseException;
import com.fourtk.syseduca.services.exceptions.ResourcesNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.NonUniqueResultException;
import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourcesNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(ResourcesNotFoundException e, HttpServletRequest request){

        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError err =  new StandardError();

        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Resources Not Found!");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(err);

    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandardError> database(DataBaseException e, HttpServletRequest request){

        HttpStatus status = HttpStatus.BAD_REQUEST;

        StandardError err =  new StandardError();

        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Database exception");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(err);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> validation(MethodArgumentNotValidException e, HttpServletRequest request){

        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;

        ValidationError err =  new ValidationError();

        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Validation exception");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());

        for (FieldError f: e.getBindingResult().getFieldErrors()) {

            err.addError(f.getField(), f.getDefaultMessage());

        }

        return ResponseEntity.status(status).body(err);

    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<StandardError> idNotFound(NullPointerException e, HttpServletRequest request){

        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError err =  new StandardError();

        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Id not found!");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(err);

    }

    @ExceptionHandler(NonUniqueResultException.class)
    public ResponseEntity<StandardError> alwaysResults(NonUniqueResultException e, HttpServletRequest request){

        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError err =  new StandardError();

        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Search with multiple results!");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(err);

    }

}
