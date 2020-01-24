package com.appify.roomtutorial;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface ItemDAO {

    @Query("Select * from todolist")
    LiveData<List<ToDoItem>> getAllItems();

    @Query("Select * from todolist where id = :itemId")
    LiveData<ToDoItem> getItem(String itemId);

    @Insert
    void insertItem(ToDoItem item);

    @Insert
    void deleteItem(ToDoItem item);
}
