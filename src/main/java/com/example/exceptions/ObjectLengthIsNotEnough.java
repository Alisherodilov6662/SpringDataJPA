package com.example.exceptions;

public class ObjectLengthIsNotEnough extends RuntimeException{
    public ObjectLengthIsNotEnough(String message) {
        super(message);
    }
}
