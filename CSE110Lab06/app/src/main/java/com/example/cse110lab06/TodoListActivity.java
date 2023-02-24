package com.example.cse110lab06;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;

import java.util.List;

public class TodoListActivity extends AppCompatActivity {
    public RecyclerView recyclerView;
    public TodoListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

        TodoListItemDao todoListItemDao = TodoDatabase.getSingleton(this).todoListItemDao();
        List<TodoListItem> todoListItems = todoListItemDao.getAll();
        TodoListAdapter adapter = new TodoListAdapter();
        adapter.setHasStableIds(true);
        adapter.setTodoListItems(todoListItems);
        adapter.setOnCheckBoxClickedHandler(viewModel::toggleCompleted);
        adapter.setOnTextEditedHandler (viewModel::updateText);

        recyclerView = findViewById(R.id.todo_items);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        adapter.setTodoListItems(TodoListItem.loadJSON(this, "demo_todos.json"));

        setContentView(R.layout.activity_todo_list);
        viewModel = new ViewModelProvider(this).get(TodoListViewModel.class);
        viewModel.getTodoListItems().observe(this, adapter::setTodoListItems);

    }
}