package com.cedrus.practice.todo.Spring_Boot_Todos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ToDoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String item;
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

    public int getId() { return this.id; }
    public void setId(int id) { this.id = id;}

    public String getItem() { return this.item; }
    public void setItem(String item) { this.item = item; }

    public boolean getImportant() { return this.important; }
    public void setImportant(boolean important) { this.important = important; }

}
