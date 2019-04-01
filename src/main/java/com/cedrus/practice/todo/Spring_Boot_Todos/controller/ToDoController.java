package com.cedrus.practice.todo.Spring_Boot_Todos.controller;

import com.cedrus.practice.todo.Spring_Boot_Todos.model.ToDoItem;
import com.cedrus.practice.todo.Spring_Boot_Todos.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/")
public class ToDoController {

    @Autowired
    ToDoService toDoService;

    @RequestMapping(value = "todos", method = RequestMethod.GET)
    public List<ToDoItem> getAll() {
        return toDoService.getAllToDos();
    }

    @RequestMapping(value = "todos", method = RequestMethod.POST)
    public void create(@RequestBody ToDoItem toDo) {
        toDoService.addToDo(toDo);
    }

    @RequestMapping(value = "todos/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable int id, @RequestBody ToDoItem toDo) {
        toDoService.updateToDo(id, toDo);
    }

    @RequestMapping(value = "todos/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        toDoService.removeToDo(id);
    }

}
