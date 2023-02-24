package com.example.cse110lab06;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TodoListViewModel extends AndroidViewModel {
    private LiveData<List<TodoListItem>> todoListItems;
    private final TodoListItemDao todoListItemDao;

    public TodoListViewModel(@NonNull Application application) {
        super(application);
        Context context = getApplication().getApplicationContext();
        TodoDatabase db = TodoDatabase.getSingleton(context);
        todoListItemDao = db.todoListItemDao();
    }
    public void toggleCompleted(TodoListItem todoListItem) {
        todoListItem.completed = !todoListItem.completed;
        todoListItemDao.update(todoListItem);
    }
    public LiveData<List<TodoListItem>> getTodoListItems() {
        if (todoListItems == null) {
            loadUsers();
        }
        return todoListItems;
    }

    private void loadUsers() {
        todoListItems = todoListItemDao.getAllLive();
    }
    public void updateText(TodoListItem todoListItem, String newText) {
        todoListItem. text = newText;
        todoListItemDao.update(todoListItem);
    }

}
