package com.appify.roomtutorial;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

import androidx.lifecycle.LiveData;

public class ItemRepository {
    LiveData<List<ToDoItem>> mItems;
    private final ItemDAO dao;

    public ItemRepository(Application application) {
        ListDatabase db = ListDatabase.getInstance(application);
        dao = db.itemDAO();
        mItems = dao.getAllItems();
    }

    class InsertTask extends AsyncTask<ToDoItem, Void, Void> {

        @Override
        protected Void doInBackground(ToDoItem... toDoItems) {
            dao.insertItem(toDoItems[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Log.d(getClass().getSimpleName(), "Item added successfully");
        }
    }

    public LiveData<List<ToDoItem>> getmItems() {
        return mItems;
    }

    public void insert(ToDoItem item) {
        new InsertTask().execute(item);
    }
}
