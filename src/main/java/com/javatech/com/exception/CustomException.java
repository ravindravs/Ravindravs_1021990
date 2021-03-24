package com.javatech.com.exception;


public class CustomException extends Exception {

    private static final long serialVersionUID = 7108160092721922439L;

    public CustomException(String name) {
        super(name);
    }
}