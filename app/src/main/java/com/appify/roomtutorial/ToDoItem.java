package com.appify.roomtutorial;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "todoList")
public class ToDoItem {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private String id;
    @ColumnInfo(name = "item")
    private String item;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "finishTime")
    private String finishTime;
    @ColumnInfo(name = "isFinished")
    private boolean isFinished;

    @Ignore
    public ToDoItem() {
    }

    public ToDoItem(@NonNull String id, String item, String description, String finishTime, boolean isFinished) {
        this.id = id;
        this.item = item;
        this.description = description;
        this.finishTime = finishTime;
        this.isFinished = isFinished;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }
}
