package com.cedrus.practice.todo.Spring_Boot_Todos.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ToDoResponse {
    private ResponseStatus responseStatus;
    private ToDoItem toDoItem;
    private List<ToDoItem> toDoItemList;

    public ToDoResponse() { }

    public ToDoResponse(ToDoItem toDoItem, int statusCode) {
        this.responseStatus = new ResponseStatus(statusCode);
        this.toDoItem = toDoItem;
    }

    public ToDoResponse(List<ToDoItem> toDoItemList, int statusCode) {
        this.responseStatus = new ResponseStatus(statusCode);
        this.toDoItemList = toDoItemList;
    }

    public ToDoResponse(boolean isSuccessful, int statusCode, String statusMessage) {
        this.responseStatus = new ResponseStatus(isSuccessful, statusCode, statusMessage);
    }
}
