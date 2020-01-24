package com.appify.roomtutorial;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class ItemViewModel extends AndroidViewModel {
    LiveData<List<ToDoItem>> mItems;
    ItemRepository repository;

    public ItemViewModel(@NonNull Application application) {
        super(application);

        repository = new ItemRepository(application);
        mItems = repository.getmItems();
    }

    public LiveData<List<ToDoItem>> getAllItems() {
        return mItems;
    }

    public void insertItem(ToDoItem item) {
        repository.insertItem(item);
    }
}
