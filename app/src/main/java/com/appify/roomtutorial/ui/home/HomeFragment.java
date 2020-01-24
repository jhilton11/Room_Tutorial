package com.appify.roomtutorial.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.appify.roomtutorial.ItemAdapter;
import com.appify.roomtutorial.ItemViewModel;
import com.appify.roomtutorial.R;
import com.appify.roomtutorial.ToDoItem;

import java.util.List;

public class HomeFragment extends Fragment {

    private ItemViewModel viewModel;
    private RecyclerView recyclerView;
    private ItemAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModel = ViewModelProviders.of(this).get(ItemViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = root.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        viewModel.getAllItems().observe(this, new Observer<List<ToDoItem>>() {
            @Override
            public void onChanged(List<ToDoItem> toDoItems) {
                adapter = new ItemAdapter(toDoItems);
                adapter.setData(toDoItems);
            }
        });
        return root;
    }
}