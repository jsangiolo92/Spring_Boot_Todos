package com.cedrus.practice.todo.Spring_Boot_Todos.model;

public class ToDoItem {
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
    public boolean getImportant() { return this.important; }

}
