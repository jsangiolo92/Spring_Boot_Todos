package com.cedrus.practice.todo.Spring_Boot_Todos.repository;

import com.cedrus.practice.todo.Spring_Boot_Todos.model.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepo extends JpaRepository<ToDoItem, Integer> {
    ToDoItem findById(int id);
}
