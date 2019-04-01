package com.cedrus.practice.todo.Spring_Boot_Todos.exception;

public class ToDoNotFoundException extends Exception {
    public ToDoNotFoundException(String message) {
        super(message);
    }
}
