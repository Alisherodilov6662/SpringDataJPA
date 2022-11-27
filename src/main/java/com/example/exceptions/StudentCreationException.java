package com.example.exceptions;

public class StudentCreationException extends RuntimeException{
    public StudentCreationException(String message) {
        super(message);
    }
}
