package com.cedrus.practice.todo.Spring_Boot_Todos.service;

import com.cedrus.practice.todo.Spring_Boot_Todos.model.ToDoItem;
import com.cedrus.practice.todo.Spring_Boot_Todos.repository.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    @Autowired
    ToDoRepo toDoRepo;

    public List<ToDoItem> getAllToDos() {
        return toDoRepo.findAll();
    }

    public void addToDo(ToDoItem toDoItem) {
        toDoRepo.save(toDoItem);
        System.out.println("ToDo item added to DB");
    }

    public void updateToDo(int id, ToDoItem newToDo) {
        ToDoItem toBeUpdated = toDoRepo.findById(id);

        if (newToDo.getItem().length() > 0) {
            toBeUpdated.setItem(newToDo.getItem());
            toDoRepo.save(toBeUpdated);
        }
        else
            System.out.println("no updated message entered");
    }

    public void removeToDo(int id) {
        toDoRepo.deleteById(id);
    }
}
