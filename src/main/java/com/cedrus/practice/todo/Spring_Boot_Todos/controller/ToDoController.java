package com.cedrus.practice.todo.Spring_Boot_Todos.controller;

import com.cedrus.practice.todo.Spring_Boot_Todos.exception.BlankToDoException;
import com.cedrus.practice.todo.Spring_Boot_Todos.exception.ToDoNotFoundException;
import com.cedrus.practice.todo.Spring_Boot_Todos.model.ToDoItem;
import com.cedrus.practice.todo.Spring_Boot_Todos.model.ToDoResponse;
import com.cedrus.practice.todo.Spring_Boot_Todos.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class ToDoController {

    @Autowired
    ToDoService toDoService;

    @CrossOrigin
    @RequestMapping(value = "todos/{id}", method = RequestMethod.GET)
    public ResponseEntity<ToDoResponse> getToDo(@PathVariable int id) {
        try {
            ToDoItem toDoItem = toDoService.getOneToDo(id);
            return marshallResponse(toDoItem, 200, HttpStatus.OK);
        }
        catch (ToDoNotFoundException notFound) {
            return marshallResponse(false, 404, notFound.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "todos", method = RequestMethod.GET)
    public ResponseEntity<ToDoResponse> getAll() {
        List<ToDoItem> toDoList = toDoService.getAllToDos();
        return marshallResponse(toDoList, 200, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "todos", method = RequestMethod.POST)
    public ResponseEntity<ToDoResponse> create(@RequestBody ToDoItem toDo) {
        try {
            toDoService.addToDo(toDo);
            return marshallResponse(true, 201, "Success", HttpStatus.CREATED);
        }
        catch (BlankToDoException blankToDo) {
            return marshallResponse(false, 400, blankToDo.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "todos/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ToDoResponse> update(@PathVariable int id, @RequestBody ToDoItem toDo) {
        try {
            toDoService.updateToDo(id, toDo);
            return marshallResponse(true, 202, "Success", HttpStatus.ACCEPTED);
        }
        catch (ToDoNotFoundException notFound) {
            return marshallResponse(false, 404, notFound.getMessage(), HttpStatus.NOT_FOUND);
        }
        catch (BlankToDoException blankToDo) {
            return marshallResponse(false, 400, blankToDo.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "todos/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ToDoResponse> delete(@PathVariable int id) {
        try {
            toDoService.removeToDo(id);
            return marshallResponse(true, 202, "Success", HttpStatus.ACCEPTED);
        }
        catch (ToDoNotFoundException notFound) {
            return marshallResponse(false, 404, notFound.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<ToDoResponse> marshallResponse(ToDoItem toDoItem, int statusCode, HttpStatus httpStatus) {
        ToDoResponse response = new ToDoResponse(toDoItem, statusCode);
        return new ResponseEntity<>(response, httpStatus);
    }

    public ResponseEntity<ToDoResponse> marshallResponse(List<ToDoItem> toDoItemList, int statusCode, HttpStatus httpStatus) {
        ToDoResponse response = new ToDoResponse(toDoItemList, statusCode);
        return new ResponseEntity<>(response, httpStatus);
    }

    public ResponseEntity<ToDoResponse> marshallResponse(boolean isSuccessful, int statusCode, String statusMessage, HttpStatus httpStatus) {
        ToDoResponse response = new ToDoResponse(isSuccessful, statusCode, statusMessage);
        return new ResponseEntity<>(response, httpStatus);
    }

}
