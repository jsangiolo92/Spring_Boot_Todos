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

    public ToDoItem getOneToDo(int id) throws ToDoNotFoundException {
        try {
            return validateToDo(id);
        }
        catch (ToDoNotFoundException notFound) {
            throw notFound;
        }
    }

    public List<ToDoItem> getAllToDos() {
        return toDoRepo.findAll();
    }

    public void addToDo(ToDoItem toDoItem) throws BlankToDoException {
        try {
            toDoItem.validateItem();
            toDoRepo.save(toDoItem);
        }
        catch (BlankToDoException blankToDo) {
            throw blankToDo;
        }
    }

    public void updateToDo(int id, ToDoItem newToDo) throws ToDoNotFoundException, BlankToDoException {
        try {
            ToDoItem toBeUpdated = validateToDo(id);
            try {
                newToDo.validateItem();
                toBeUpdated.setItem(newToDo.getItem());
                toDoRepo.save(toBeUpdated);
            }
            catch (BlankToDoException blankToDo) {
                throw blankToDo;
            }
        }
        catch (ToDoNotFoundException notFound) {
            throw notFound;
        }
    }

    public void removeToDo(int id) throws ToDoNotFoundException {
        try {
            ToDoItem toBeDeleted = validateToDo(id);
            toDoRepo.deleteById(id);
        }
        catch (ToDoNotFoundException notFound) {
            throw notFound;
        }
    }

    private ToDoItem validateToDo(int id) throws ToDoNotFoundException{
        ToDoItem toDoItem = toDoRepo.findById(id);
        if (toDoItem == null)
            throw new ToDoNotFoundException(String.format("ToDo not found for id: " + id));
        return toDoItem;
    }
}
