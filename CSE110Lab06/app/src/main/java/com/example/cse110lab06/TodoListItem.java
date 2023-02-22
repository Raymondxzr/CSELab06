package com.example.cse110lab06;

public class TodoListItem {
    public long id = 0;
    public String text;
    public boolean completed;
    public int order;

    TodoListItem(String text, boolean completed, int order) {
        this.text = text;
        this.completed = completed;
        this.order = order;
    }

}
