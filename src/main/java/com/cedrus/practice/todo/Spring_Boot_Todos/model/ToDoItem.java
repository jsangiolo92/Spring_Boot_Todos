package com.cedrus.practice.todo.Spring_Boot_Todos.model;

import com.cedrus.practice.todo.Spring_Boot_Todos.exception.BlankToDoException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class ToDoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String item;
    private String detail;
    private  boolean important;

    public ToDoItem() {}

    public ToDoItem(int id, String item) {
        this.id = id;
        this.item = item;
        this.important = false;
    }

    public ToDoItem(int id, String item, boolean important) {
        this(id, item);
        this.important = important;
    }

    public void validateItem() throws BlankToDoException {
        if (getItem().length() < 1)
            throw new BlankToDoException("Empty item field entered");
    }

    public boolean getImportant() {
        return this.important;
    }
}
