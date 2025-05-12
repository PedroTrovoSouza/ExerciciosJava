package com.example.demo.exception;


public class TarefaInvalidaException extends RuntimeException {
    public TarefaInvalidaException(String message) {
        super(message);
    }
}
