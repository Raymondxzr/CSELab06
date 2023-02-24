package com.example.cse110lab06;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RoomDatabase;
import androidx.room.Update;

import java.util.List;
@Dao
public interface TodoListItemDao {
    @Query("SELECT * FROM `todo_list_items` ORDER BY `order`")
    LiveData<List<TodoListItem>> getAllLive();

    @Insert
    long insert(TodoListItem todoListItem);

    @Query("SELECT * FROM `todo_list_items` WHERE `id`=:id")
    TodoListItem get(long id);

    @Query("SELECT * FROM `todo_list_items` ORDER BY `order`")
    List<TodoListItem> getAll();

    @Update
    int update(TodoListItem todoListItem);

    @Delete
    int delete(TodoListItem todoListItem);

    @Insert
    List<Long> insertAll(List<TodoListItem> todoListItem);

    @Database(entities = {TodoListItem .class}, version = 1)
    public abstract class TodoDatabase extends RoomDatabase {

    }
}

