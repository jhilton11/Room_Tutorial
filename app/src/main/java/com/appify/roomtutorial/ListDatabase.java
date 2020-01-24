package com.appify.roomtutorial;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {ToDoItem.class}, version = 1, exportSchema = false)
public abstract class ListDatabase extends RoomDatabase {
    private static final String DB_NAME = "todoList_db";
    private static ListDatabase instance;

    public static synchronized ListDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), ListDatabase.class, DB_NAME)
            .build();
        }
        return instance;
    }

    public abstract ItemDAO itemDAO();
}
