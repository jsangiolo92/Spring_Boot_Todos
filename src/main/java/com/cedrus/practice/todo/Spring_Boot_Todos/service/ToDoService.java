package com.cedrus.practice.todo.Spring_Boot_Todos.service;

import com.cedrus.practice.todo.Spring_Boot_Todos.exception.BlankToDoException;
import com.cedrus.practice.todo.Spring_Boot_Todos.exception.ToDoNotFoundException;
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

    public void addToDo(ToDoItem toDoItem) throws BlankToDoException {
        if (toDoItem.getItem().length() < 1)
            throw new BlankToDoException("No text entered for to do!");

        toDoRepo.save(toDoItem);
        System.out.println("ToDo item added to DB");
    }

    public void updateToDo(int id, ToDoItem newToDo) throws ToDoNotFoundException, BlankToDoException {
        ToDoItem toBeUpdated = toDoRepo.findById(id);

        if (toBeUpdated == null)
            throw new ToDoNotFoundException(String.format("ToDo not found for id: " + id));

        if (newToDo.getItem().length() < 1)
            throw new BlankToDoException("No text entered for to do");

        toBeUpdated.setItem(newToDo.getItem());
        toDoRepo.save(toBeUpdated);
    }

    public void removeToDo(int id) throws ToDoNotFoundException {
        ToDoItem toBeDeleted = toDoRepo.findById(id);

        if (toBeDeleted == null)
            throw new ToDoNotFoundException(String.format("Todo not found for id: " + id));

        toDoRepo.deleteById(id);
    }
}
