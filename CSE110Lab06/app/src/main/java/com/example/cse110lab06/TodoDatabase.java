package com.example.cse110lab06;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {TodoListItem.class}, version = 1)
public abstract class TodoDatabase extends RoomDatabase {
    public abstract TodoListItemDao todoListItemDao();
}
