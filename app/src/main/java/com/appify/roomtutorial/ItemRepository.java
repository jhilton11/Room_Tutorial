package com.appify.roomtutorial;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.List;

import androidx.lifecycle.LiveData;

public class ItemRepository {
    LiveData<List<ToDoItem>> mItems;
    private final ItemDAO dao;

    public ItemRepository(Application application) {
        ListDatabase db = ListDatabase.getInstance(application);
        dao = db.itemDAO();
        getAllItems();
    }

    public void insertItem(final ToDoItem item) {
        AsyncTask<ToDoItem, Void, Void> insertTask = new AsyncTask<ToDoItem, Void, Void>() {
            @Override
            protected Void doInBackground(ToDoItem... toDoItems) {
                dao.insertItem(toDoItems[0]);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                ///Toast.makeText(application, "Item inserted successfully", Toast.LENGTH_SHORT).show();
                super.onPostExecute(aVoid);
            }
        }.execute(item);
    }

    public void getAllItems() {
        AsyncTask<Void, Void, LiveData<List<ToDoItem>>> getItemsTask = new AsyncTask<Void, Void, LiveData<List<ToDoItem>>>() {
            @Override
            protected LiveData<List<ToDoItem>> doInBackground(Void... voids) {
                mItems = dao.getAllItems();
                return mItems;
            }

            @Override
            protected void onPostExecute(LiveData<List<ToDoItem>> listLiveData) {
                super.onPostExecute(listLiveData);
                mItems = listLiveData;
            }
        }.execute();
    }

    public LiveData<List<ToDoItem>> getmItems() {
        return mItems;
    }
}
