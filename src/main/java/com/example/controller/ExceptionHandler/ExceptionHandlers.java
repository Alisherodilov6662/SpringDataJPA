package com.example.controller.ExceptionHandler;

import com.example.exceptions.ObjectLengthIsNotEnough;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.exceptions.StudentCreationException;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler({ObjectNotFoundException.class, StudentCreationException.class, ObjectLengthIsNotEnough.class})
    public ResponseEntity<?> handle(RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}

