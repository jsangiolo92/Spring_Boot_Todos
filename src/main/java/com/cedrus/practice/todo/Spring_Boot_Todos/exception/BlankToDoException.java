package com.cedrus.practice.todo.Spring_Boot_Todos.exception;

public class BlankToDoException extends Exception {
    public BlankToDoException(String message) {
        super(message);
    }

    public BlankToDoException(String message, Throwable exception) {
        super(message, exception);
    }
}
